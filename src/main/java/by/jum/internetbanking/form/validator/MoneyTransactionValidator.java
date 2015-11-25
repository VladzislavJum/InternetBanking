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
        private static final int MIN_VALUE = 100;

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
            checkAccountNumber(transactionForm, errors, "objectTo");
        }


    }

    private void checkBelongUser(String numberAccountFrom, Errors errors) {
        if (accountFacade.getAccountByNumber(numberAccountFrom).getUserID() != userFacade.getIDCurrentUser()) {
            errors.rejectValue("numberAccountFrom", "moneytrans.label.error.belong");
        }
    }

    private void checkAccountNumber(MoneyTransactionForm transactionForm, Errors errors, String param) {
        String accountNumberTo = transactionForm.getObjectTo();
        String accountNumberFrom = transactionForm.getNumberAccountFrom();

        if (accountNumberTo.equals(accountNumberFrom)) {
            errors.rejectValue(param, "moneytrans.label.error.equalsacc");
        } else {
            if (StringUtils.isEmpty(accountNumberTo)) {
                errors.rejectValue(param, "common.label.error.emptyfield");
            } else if (accountNumberTo.length() > 10 || accountNumberTo.length() < 4) {
                errors.rejectValue(param, "createaccount.label.error.accountnumbersize");
            } else {
                pattern = Pattern.compile(NUMBER_ACCOUNT_PATTERN);
                matcher = pattern.matcher(accountNumberTo);
                if (!matcher.matches()) {
                    errors.rejectValue(param, "common.label.error.numericletters");
                } else if (accountFacade.getAccountByNumber(accountNumberTo) == null) {
                    errors.rejectValue(param, "searchaccount.label.error.accountnotexist");
                } else {
                    checkAmountOfMoney(transactionForm.getAmountOfTransferredMoney(), accountNumberFrom, errors, "amountOfTransferredMoney");
                }
            }
        }
    }

    public void checkAmountOfMoney(String amountOfMoney, String numberAccountFrom, Errors errors, String param) {
        if (StringUtils.isEmpty(amountOfMoney)) {
            errors.rejectValue(param, "common.label.error.emptyfield");
        } else if (amountOfMoney.length() > 10 || amountOfMoney.length() < 3) {
            errors.rejectValue(param, "createaccount.label.error.amounofmoneysize");
        } else {
            pattern = Pattern.compile(NUMBER_PATTERN);
            matcher = pattern.matcher(amountOfMoney);
            if (!matcher.matches()) {
                errors.rejectValue(param, "common.label.error.numeric");
            } else {
                BigDecimal amountOfMoneyFrom = accountFacade.getAccountByNumber(numberAccountFrom).getAmountOfMoney();
                BigDecimal amountOfTransferredMoney = new BigDecimal(amountOfMoney);
                if (amountOfMoneyFrom.compareTo(amountOfTransferredMoney) == LESS_VALUE ||
                        amountOfTransferredMoney.compareTo(new BigDecimal(MIN_VALUE)) == LESS_VALUE) {
                    errors.rejectValue(param, "moneytrans.label.error.moneyless");
                } else {
                    checkBelongUser(numberAccountFrom, errors);
                }
            }
        }
    }
}
