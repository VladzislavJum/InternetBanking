package by.jum.internetbanking.form.validator;

import by.jum.internetbanking.facade.BankAccountFacade;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.form.account.CreateBankAccountForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CreateBankAccountFormValidator implements Validator {

    private static final String MONEY_PATTERN = "[0-9]+";
    private static final String LOGIN_NUMBER_PATTERN = "[a-zA-Z0-9]+";

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private BankAccountFacade accountFacade;

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
        } else if (accountNumber.length() > 10 || accountNumber.length() < 4) {
            errors.rejectValue(param, "createaccount.label.error.accountnumbersize");
        } else {
            pattern = Pattern.compile(LOGIN_NUMBER_PATTERN);
            matcher = pattern.matcher(accountNumber);
            if (!matcher.matches()) {
                errors.rejectValue(param, "common.label.error.numericletters");
            } else if (accountFacade.getAccountByNumber(accountNumber) != null) {
                errors.rejectValue(param, "createaccount.label.error.numberexist");
            }
        }
    }

    public void checkAmountOfMoney(String amountOfMoney, Errors errors, String param) {
        if (StringUtils.isEmpty(amountOfMoney)) {
            errors.rejectValue(param, "common.label.error.emptyfield");
        } else if (amountOfMoney.length() > 10 || amountOfMoney.length() < 3) {
            errors.rejectValue(param, "createaccount.label.error.amounofmoneysize");
        } else {
            pattern = Pattern.compile(MONEY_PATTERN);
            matcher = pattern.matcher(amountOfMoney);
            if (!matcher.matches()) {
                errors.rejectValue(param, "common.label.error.numeric");
            }
        }
    }

    private void checkUserLogin(String userLogin, Errors errors, String param) {
        if (StringUtils.isEmpty(userLogin)) {
            errors.rejectValue(param, "common.label.error.emptyfield");
        } else if (userLogin.length() > 15 || userLogin.length() < 4) {
            errors.rejectValue(param, "common.label.error.loginsize");
        } else {
            pattern = Pattern.compile(LOGIN_NUMBER_PATTERN);
            matcher = pattern.matcher(userLogin);
            if (!matcher.matches()) {
                errors.rejectValue(param, "common.label.error.numericletters");
            } else if (userFacade.getUserByUserName(userLogin) == null) {
                errors.rejectValue(param, "createaccount.label.error.usernotexist");
            }
        }

    }
}
