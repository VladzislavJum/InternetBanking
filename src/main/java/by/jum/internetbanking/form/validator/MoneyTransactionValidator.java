package by.jum.internetbanking.form.validator;

import by.jum.internetbanking.facade.BankAccountFacade;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.form.money.MoneyTransactionForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class MoneyTransactionValidator implements Validator {

    private static final String NUMBER_PATTERN = "[0-9]+";
    private static final String NUMBER_ACCOUNT_PATTERN = "[a-zA-Z0-9]+";
    private static final int LESS_VALUE = -1;

    private Pattern pattern;
    private Matcher matcher;

    @Autowired
    private BankAccountFacade accountFacade;

    @Autowired
    private UserFacade userFacade;

    @Override
    public boolean supports(Class<?> clazz) {
        return MoneyTransactionForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MoneyTransactionForm transactionForm = (MoneyTransactionForm) target;
        if (StringUtils.isEmpty(transactionForm.getNumberAccountFrom())) {
            errors.rejectValue("numberAccountFrom", "moneytrans.label.error.requiredaccount");
        } else {
            checkAccountNumber(transactionForm, errors, "numberAccountTo");
        }


    }

    private void checkAmountOfMoney(MoneyTransactionForm transactionForm, Errors errors, String param) {
        String amountOfMoney = transactionForm.getAmountOfTransferredMoney();
        String numberAccountFrom = transactionForm.getNumberAccountFrom();
        if (StringUtils.isEmpty(amountOfMoney)) {
            errors.rejectValue(param, "common.label.error.emptyfield");
        } else if (amountOfMoney.length() > 10 || amountOfMoney.length() < 3) {
            errors.rejectValue(param, "createaccount.label.error.amounofmoneysize");
        } else {
            pattern = Pattern.compile(NUMBER_PATTERN);
            matcher = pattern.matcher(amountOfMoney);
            if (!matcher.matches()) {
                errors.rejectValue(param, "common.label.error.numeric");
            }

            BigDecimal amountOfMoneyFrom = accountFacade.getAccountByNumber(numberAccountFrom).getAmountOfMoney();
            BigDecimal amountOfTransferredMoney = new BigDecimal(amountOfMoney);

            if (amountOfMoneyFrom.compareTo(amountOfTransferredMoney) == LESS_VALUE) {
                errors.rejectValue(param, "moneytrans.label.error.moneyless");
            } else {
                checkBelongUser(transactionForm, errors);
            }
        }
    }

    private void checkBelongUser(MoneyTransactionForm transactionForm, Errors errors) {
        if (accountFacade.getAccountByNumber(transactionForm.getNumberAccountFrom()).getUserID() != userFacade.getIDCurrentUser()) {
            errors.rejectValue("numberAccountFrom", "moneytrans.label.error.belong");
        }
    }

    public void checkAccountNumber(MoneyTransactionForm transactionForm, Errors errors, String param) {
        String accountNumber = transactionForm.getNumberAccountTo();
        if (StringUtils.isEmpty(accountNumber)) {
            errors.rejectValue(param, "common.label.error.emptyfield");
        } else if (accountNumber.length() > 10 || accountNumber.length() < 4) {
            errors.rejectValue(param, "createaccount.label.error.accountnumbersize");
        } else {
            pattern = Pattern.compile(NUMBER_ACCOUNT_PATTERN);
            matcher = pattern.matcher(accountNumber);
            if (!matcher.matches()) {
                errors.rejectValue(param, "common.label.error.numericletters");
            } else if (accountFacade.getAccountByNumber(accountNumber) == null) {
                errors.rejectValue(param, "searchaccount.label.error.accountnotexist");
            } else {
                checkAmountOfMoney(transactionForm, errors, "amountOfTransferredMoney");
            }
        }
    }
}
