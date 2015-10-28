package by.jum.internetbanking.form.validator;

import by.jum.internetbanking.form.account.CreateBankAccountForm;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("accountFormValidator")
public class CreateBankAccountFormValidator implements Validator {
    private static final Logger LOGGER = Logger.getLogger(CreateBankAccountFormValidator.class);

    private Pattern pattern;
    private Matcher matcher;

    private static final String NUMBER_PATTERN = "[0-9]+";

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CreateBankAccountForm accountForm = (CreateBankAccountForm) target;

        checkAccountNumber(accountForm.getAccountNumber(), errors);
        checkAmountOfMoney(accountForm.getAmountOfMoney(), errors);


    }

    private void checkAccountNumber(String accountNumber, Errors errors){
        if(!StringUtils.hasText(accountNumber)){
            errors.rejectValue("accountNumber", "validation.label.emptyfield");
        } else if(accountNumber.length() > 15 || accountNumber.length() < 4){
            errors.rejectValue("accountNumber", "validation.createaccount.label.accountnumbersize");
        } else {
            pattern = Pattern.compile(NUMBER_PATTERN);
            matcher = pattern.matcher(accountNumber);
            if (!matcher.matches()) {
                errors.rejectValue("accountNumber", "error.label.url");
            }
        }
    }

    private void checkAmountOfMoney(String amountOfMoney, Errors errors){
        if(!StringUtils.hasText(amountOfMoney)){
            errors.rejectValue("amountOfMoney", "validation.label.emptyfield");
        } else if(amountOfMoney.length() > 13 || amountOfMoney.length() < 3){
            errors.rejectValue("amountOfMoney", "validation.createaccount.label.accountnumbersize");
        } else {
            pattern = Pattern.compile(NUMBER_PATTERN);
            matcher = pattern.matcher(amountOfMoney);
            if (!matcher.matches()) {
                errors.rejectValue("amountOfMoney", "error.label.url");
            }
        }
    }

}
