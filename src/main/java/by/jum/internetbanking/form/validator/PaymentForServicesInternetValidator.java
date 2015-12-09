package by.jum.internetbanking.form.validator;

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
public class PaymentForServicesInternetValidator implements Validator {

    private static final Logger LOGGER = Logger.getLogger(PaymentForServicesInternetValidator.class);

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
        return PaymentForServicesInternetValidator.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PaymentForServicesForm servicesForm = (PaymentForServicesForm) target;

        if (corporationService.getByName(servicesForm.getNameCorp()) == null) {
            errors.rejectValue("nameCorp", "paymentserv.label.namecorp");
            LOGGER.info("nameCorp not exist error");
        } else {
            checkNumberCorporationAcc(servicesForm.getNumberCorporationAcc(), errors);
            if (StringUtils.isEmpty(servicesForm.getNumberAccountFrom())) {
                errors.rejectValue("numberAccountFrom", "moneytrans.label.error.requiredaccount");
                LOGGER.info("empty nameCorp error");
            } else {
                checkAmountOfMoney(servicesForm.getAmountOfMoney(), servicesForm.getNumberAccountFrom(), errors, "amountOfMoney");
            }
        }
    }

    private void checkNumberCorporationAcc(String numberCorporationAcc, Errors errors) {
        if (StringUtils.isEmpty(numberCorporationAcc)) {
            errors.rejectValue("numberCorporationAcc", "common.label.error.emptyfield");
            LOGGER.info("empty numberCorporationAcc error");
        } else if (numberCorporationAcc.length() > 10 || numberCorporationAcc.length() < 4) {
            errors.rejectValue("numberCorporationAcc", "paymentserv.label.error.phonenumbersize");
            LOGGER.info("size numberCorporationAcc error");
        } else {
            Pattern pattern = Pattern.compile(ValidationConstants.PASSPORT_NUMBER_LOGIN_PASS_PATTERN.getPattern());
            Matcher matcher = pattern.matcher(numberCorporationAcc);
            if (!matcher.matches()) {
                errors.rejectValue("numberCorporationAcc", "common.label.error.numericletters");
                LOGGER.info("content numberCorporationAcc error");
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
