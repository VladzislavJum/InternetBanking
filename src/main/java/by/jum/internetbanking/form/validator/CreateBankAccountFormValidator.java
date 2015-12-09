package by.jum.internetbanking.form.validator;

import by.jum.internetbanking.form.account.CreateBankAccountForm;
import by.jum.internetbanking.service.BankAccountService;
import by.jum.internetbanking.service.UserService;
import by.jum.internetbanking.util.ValidationConstants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CreateBankAccountFormValidator implements Validator {

    private static final Logger LOGGER = Logger.getLogger(CreateBankAccountFormValidator.class);

    @Autowired
    private UserService userService;

    @Autowired
    private BankAccountService accountService;

    private Pattern pattern;
    private Matcher matcher;

    @Override
    public boolean supports(Class<?> clazz) {
        return CreateBankAccountForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CreateBankAccountForm accountForm = (CreateBankAccountForm) target;
        checkAccountNumber(accountForm.getAccountNumber(), errors, "accountNumber");
        checkAmountOfMoney(accountForm.getAmountOfMoney(), errors, "amountOfMoney");
        checkUserLogin(accountForm.getUserLogin(), errors, "userLogin");
    }

    private void checkAccountNumber(String accountNumber, Errors errors, String param) {
        if (StringUtils.isEmpty(accountNumber)) {
            errors.rejectValue(param, "common.label.error.emptyfield");
            LOGGER.info(param + " empty error");
        } else if (accountNumber.length() > 10 || accountNumber.length() < 4) {
            errors.rejectValue(param, "createaccount.label.error.accountnumbersize");
            LOGGER.info(param + " size error");
        } else {
            pattern = Pattern.compile(ValidationConstants.PASSPORT_NUMBER_LOGIN_PASS_PATTERN.getPattern());
            matcher = pattern.matcher(accountNumber);
            if (!matcher.matches()) {
                errors.rejectValue(param, "common.label.error.numericletters");
                LOGGER.info(param + " content error");
            } else if (accountService.getAccountByNumber(accountNumber) != null) {
                errors.rejectValue(param, "createaccount.label.error.numberexist");
                LOGGER.info(param + " already exist error");
            }
        }
    }

    public void checkAmountOfMoney(String amountOfMoney, Errors errors, String param) {
        if (StringUtils.isEmpty(amountOfMoney)) {
            errors.rejectValue(param, "common.label.error.emptyfield");
            LOGGER.info(param + " empty error");
        } else if (amountOfMoney.length() > 10 || amountOfMoney.length() < 3) {
            errors.rejectValue(param, "createaccount.label.error.amounofmoneysize");
            LOGGER.info(param + " size amountOfMoney error");
        } else {
            pattern = Pattern.compile(ValidationConstants.NUMBER_PATTERN.getPattern());
            matcher = pattern.matcher(amountOfMoney);
            if (!matcher.matches()) {
                errors.rejectValue(param, "common.label.error.numeric");
                LOGGER.info(param + " content error");
            }
        }
    }

    private void checkUserLogin(String userLogin, Errors errors, String param) {
        if (StringUtils.isEmpty(userLogin)) {
            errors.rejectValue(param, "common.label.error.emptyfield");
            LOGGER.info(param + " empty error");
        } else if (userLogin.length() > 15 || userLogin.length() < 4) {
            errors.rejectValue(param, "common.label.error.loginsize");
        } else {
            pattern = Pattern.compile(ValidationConstants.PASSPORT_NUMBER_LOGIN_PASS_PATTERN.getPattern());
            matcher = pattern.matcher(userLogin);
            if (!matcher.matches()) {
                errors.rejectValue(param, "common.label.error.numericletters");
                LOGGER.info(param + " content error");
            } else if (userService.getByUserName(userLogin) == null) {
                errors.rejectValue(param, "createaccount.label.error.usernotexist");
                LOGGER.info(param + " not exist error");
            }
        }

    }
}
