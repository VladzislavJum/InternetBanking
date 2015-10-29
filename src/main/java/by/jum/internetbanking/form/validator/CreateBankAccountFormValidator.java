package by.jum.internetbanking.form.validator;

import by.jum.internetbanking.facade.BankAccountFacade;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.form.account.CreateBankAccountForm;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("accountFormValidator")
public class CreateBankAccountFormValidator implements Validator {

    private static final Logger LOGGER = Logger.getLogger(CreateBankAccountFormValidator.class);

    private static final String NUMBER_PATTERN = "[0-9]+";
    private static final String LOGIN_PATTERN = "[a-zA-Z0-9]+";

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
        checkAccountNumber(accountForm.getAccountNumber(), errors);
        checkAmountOfMoney(accountForm.getAmountOfMoney(), errors);
        checkUserLogin(accountForm.getUserLogin(), errors);
    }

    private void checkAccountNumber(String accountNumber, Errors errors) {
        if (!StringUtils.hasText(accountNumber)) {
            errors.rejectValue("accountNumber", "validation.label.emptyfield");
        } else if (accountNumber.length() > 15 || accountNumber.length() < 4) {
            errors.rejectValue("accountNumber", "validation.createaccount.label.accountnumbersize");
        } else {
            pattern = Pattern.compile(NUMBER_PATTERN);
            matcher = pattern.matcher(accountNumber);
            if (!matcher.matches()) {
                errors.rejectValue("accountNumber", "validation.label.numeric");
            } else if (accountFacade.isExistNumber(Integer.valueOf(accountNumber))) {
                errors.rejectValue("accountNumber", "validation.createaccount.label.numberexist");
            }
        }
    }

    private void checkAmountOfMoney(String amountOfMoney, Errors errors) {
        if (!StringUtils.hasText(amountOfMoney)) {
            errors.rejectValue("amountOfMoney", "validation.label.emptyfield");
        } else if (amountOfMoney.length() > 13 || amountOfMoney.length() < 3) {
            errors.rejectValue("amountOfMoney", "validation.createaccount.label.amounofmoneysize");
        } else {
            pattern = Pattern.compile(NUMBER_PATTERN);
            matcher = pattern.matcher(amountOfMoney);
            if (!matcher.matches()) {
                errors.rejectValue("amountOfMoney", "validation.label.numeric");
            }
        }
    }

    private void checkUserLogin(String userLogin, Errors errors) {
        if (!StringUtils.hasText(userLogin)) {
            errors.rejectValue("userLogin", "validation.label.emptyfield");
        } else if (userLogin.length() > 15 || userLogin.length() < 4) {
            errors.rejectValue("userLogin", "validation.createaccount.label.loginsize");
        } else {
            pattern = Pattern.compile(LOGIN_PATTERN);
            matcher = pattern.matcher(userLogin);
            if (!matcher.matches()) {
                errors.rejectValue("userLogin", "validation.createaccount.loginnumericletters");
            } else if (userFacade.getUserByUserName(userLogin) == null) {
                errors.rejectValue("userLogin", "validation.createaccount.label.usernotexist");
            }
        }

    }
}
