package by.jum.internetbanking.validator;

import by.jum.internetbanking.form.money.PaymentForServicesForm;
import by.jum.internetbanking.service.BankAccountService;
import by.jum.internetbanking.service.CorporationService;
import by.jum.internetbanking.service.UserService;
import by.jum.internetbanking.util.ValidationConstants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PaymentForServicesMobileValidator implements Validator {

    private static final Logger LOGGER = Logger.getLogger(PaymentForServicesMobileValidator.class);

    private static final int LESS_VALUE = -1;
    private static final int MIN_VALUE = 100;

    @Autowired
    private BankAccountService accountService;

    @Autowired
    private UserService userService;

    @Autowired
    private CorporationService corporationService;

    @Override
    public boolean supports(Class<?> clazz) {
        return PaymentForServicesMobileValidator.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PaymentForServicesForm servicesForm = (PaymentForServicesForm) target;

        if (corporationService.getByName(servicesForm.getNameCorp()) == null) {
            errors.rejectValue("nameCorp", "paymentserv.label.namecorp");
            LOGGER.info("nameCorp not exist error");
        } else {
            checkNumberPhone(servicesForm.getPhoneNumber(), errors);
            if (StringUtils.isEmpty(servicesForm.getNumberAccountFrom())) {
                errors.rejectValue("numberAccountFrom", "moneytrans.label.error.requiredaccount");
                LOGGER.info("empty nameCorp error");
            } else {
                checkAmountOfMoney(servicesForm.getAmountOfMoney(), servicesForm.getNumberAccountFrom(), errors, "amountOfMoney");
            }
        }
    }

    private void checkNumberPhone(String phoneNumber, Errors errors) {
        if (StringUtils.isEmpty(phoneNumber)) {
            errors.rejectValue("phoneNumber", "common.label.error.emptyfield");
            LOGGER.info("empty phoneNumber error");
        } else if (phoneNumber.length() != 13) {
            errors.rejectValue("phoneNumber", "paymentserv.label.error.phonenumbersize");
            LOGGER.info("size phoneNumber error");
        } else {
            Pattern pattern = Pattern.compile(ValidationConstants.PHONE_NUMBER.getPattern());
            Matcher matcher = pattern.matcher(phoneNumber);
            if (!matcher.matches()) {
                errors.rejectValue("phoneNumber", "paymentserv.label.error.phonenumbercontent");
                LOGGER.info("content phoneNumber error");
            }
        }
    }

    private void checkAmountOfMoney(String amountOfMoney, String numberAccountFrom, Errors errors, String param) {
        if (StringUtils.isEmpty(amountOfMoney)) {
            errors.rejectValue(param, "common.label.error.emptyfield");
            LOGGER.info(param + " empty error");
        } else if (amountOfMoney.length() > 10 || amountOfMoney.length() < 3) {
            errors.rejectValue(param, "createaccount.label.error.amounofmoneysize");
            LOGGER.info(param + " size error");
        } else {
            Pattern pattern = Pattern.compile(ValidationConstants.NUMBER_PATTERN.getPattern());
            Matcher matcher = pattern.matcher(amountOfMoney);
            if (!matcher.matches()) {
                errors.rejectValue(param, "common.label.error.numeric");
                LOGGER.info(param + " content error");
            } else {
                BigDecimal amountOfMoneyFrom = accountService.getAccountByNumber(numberAccountFrom).getAmountOfMoney();
                BigDecimal amountOfTransferredMoney = new BigDecimal(amountOfMoney);
                if (amountOfMoneyFrom.compareTo(amountOfTransferredMoney) == LESS_VALUE ||
                        amountOfTransferredMoney.compareTo(new BigDecimal(MIN_VALUE)) == LESS_VALUE) {
                    errors.rejectValue(param, "moneytrans.label.error.moneyless");
                    LOGGER.info(param + " not enough error");
                } else {
                    checkBelongUser(numberAccountFrom, errors);
                }
            }
        }
    }

    private void checkBelongUser(String numberAccountFrom, Errors errors) {
        if (accountService.getAccountByNumber(numberAccountFrom).getUser().getUserID() != userService.getIDCurrentUser()) {
            errors.rejectValue("numberAccountFrom", "moneytrans.label.error.belong");
            LOGGER.info("not belong user error");
        }
    }

}
