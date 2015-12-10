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
public class PaymentForServicesUtilitiesValidator implements Validator {

    private static final Logger LOGGER = Logger.getLogger(PaymentForServicesUtilitiesValidator.class);

    private static final int LESS_VALUE = -1;
    private static final int TARIFF = 1000;

    @Autowired
    private BankAccountService accountService;

    @Autowired
    private UserService userService;

    @Autowired
    private CorporationService corporationService;

    @Override
    public boolean supports(Class<?> clazz) {
        return PaymentForServicesUtilitiesValidator.class.isAssignableFrom(clazz);
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
                checkAmount(servicesForm.getAmount(), servicesForm.getNumberAccountFrom(), errors, "amount");
            }
        }
    }

    private void checkNumberCorporationAcc(String numberCorporationAcc, Errors errors) {
        if (StringUtils.isEmpty(numberCorporationAcc)) {
            errors.rejectValue("numberCorporationAcc", "common.label.error.emptyfield");
            LOGGER.info("empty numberCorporationAcc error");
        } else if (numberCorporationAcc.length() > 10 || numberCorporationAcc.length() < 4) {
            errors.rejectValue("numberCorporationAcc", "createaccount.label.error.accountnumbersize");
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

    private void checkAmount(String amount, String numberAccountFrom, Errors errors, String param) {
        if (StringUtils.isEmpty(amount)) {
            errors.rejectValue(param, "common.label.error.emptyfield");
            LOGGER.info(param + " empty error");
        } else if (amount.length() > 5) {
            errors.rejectValue(param, "paymentserv.label.error.electrsize");
            LOGGER.info(param + " size error");
        } else {
            Pattern pattern = Pattern.compile(ValidationConstants.NUMBER_PATTERN.getPattern());
            Matcher matcher = pattern.matcher(amount);
            if (!matcher.matches()) {
                errors.rejectValue(param, "common.label.error.numeric");
                LOGGER.info(param + " content error");
            } else {
                BigDecimal amountOfMoneyFrom = accountService.getAccountByNumber(numberAccountFrom).getAmountOfMoney();
                BigDecimal amountOfTransferred = new BigDecimal(amount);
                if (amountOfMoneyFrom.compareTo(amountOfTransferred.multiply(new BigDecimal(TARIFF))) == LESS_VALUE) {
                    errors.rejectValue(param, "paymentserv.label.error.electramount");
                    LOGGER.info(param + " much error");
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
