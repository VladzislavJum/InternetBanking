package by.jum.internetbanking.form.validator;

import by.jum.internetbanking.facade.BankAccountFacade;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.form.money.MoneyTransactionForm;
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
public class MoneyTransactionValidator implements Validator {

    private static final Logger LOGGER = Logger.getLogger(MoneyTransactionValidator.class);

    private static final String NUMBER_PATTERN = "[0-9]+";
    private static final String NUMBER_ACCOUNT_PATTERN = "[a-zA-Z0-9]+";
    private static final int LESS_VALUE = -1;
    private static final String MIN_VALUE = "100";

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
            LOGGER.info("empty numberAccountFrom error");
        } else {
            checkAccountNumber(transactionForm, errors, "objectTo");
        }
    }

    private void checkBelongUser(String numberAccountFrom, Errors errors) {
        if (accountFacade.getAccountByNumber(numberAccountFrom).getUserID() != userFacade.getIDCurrentUser()) {
            errors.rejectValue("numberAccountFrom", "moneytrans.label.error.belong");
            LOGGER.info("not belong user error");
        }
    }

    private void checkAccountNumber(MoneyTransactionForm transactionForm, Errors errors, String param) {
        String accountNumberTo = transactionForm.getObjectTo();
        String accountNumberFrom = transactionForm.getNumberAccountFrom();

        if (accountNumberTo.equals(accountNumberFrom)) {
            errors.rejectValue(param, "moneytrans.label.error.equalsacc");
            LOGGER.info("equals accounts error");
        } else {
            if (StringUtils.isEmpty(accountNumberTo)) {
                errors.rejectValue(param, "common.label.error.emptyfield");
                LOGGER.info("empty objectTo error");
            } else if (accountNumberTo.length() > 10 || accountNumberTo.length() < 4) {
                errors.rejectValue(param, "createaccount.label.error.accountnumbersize");
                LOGGER.info("size objectTo error");
            } else {
                pattern = Pattern.compile(NUMBER_ACCOUNT_PATTERN);
                matcher = pattern.matcher(accountNumberTo);
                if (!matcher.matches()) {
                    errors.rejectValue(param, "common.label.error.numericletters");
                    LOGGER.info("content objectTo error");
                } else if (accountFacade.getAccountByNumber(accountNumberTo) == null) {
                    errors.rejectValue(param, "searchaccount.label.error.accountnotexist");
                    LOGGER.info("objectTo not exist error");
                } else {
                    checkAmountOfMoney(transactionForm.getAmountOfTransferredMoney(), accountNumberFrom, errors, "amountOfTransferredMoney");
                }
            }
        }
    }

    public void checkAmountOfMoney(String amountOfMoney, String numberAccountFrom, Errors errors, String param) {
        if (StringUtils.isEmpty(amountOfMoney)) {
            errors.rejectValue(param, "common.label.error.emptyfield");
            LOGGER.info(param + " empty error");
        } else if (amountOfMoney.length() > 10 || amountOfMoney.length() < 3) {
            errors.rejectValue(param, "createaccount.label.error.amounofmoneysize");
            LOGGER.info(param + " size error");
        } else {
            pattern = Pattern.compile(NUMBER_PATTERN);
            matcher = pattern.matcher(amountOfMoney);
            if (!matcher.matches()) {
                errors.rejectValue(param, "common.label.error.numeric");
                LOGGER.info(param + " content error");
            } else {
                String amountOfMoneyFrom = accountFacade.getAccountByNumber(numberAccountFrom).getAmountOfMoney();
//                String amountOfTransferredMoney = new BigDecimal(amountOfMoney);
                if (amountOfMoneyFrom.compareTo(amountOfMoney) <= LESS_VALUE ||
                        amountOfMoney.compareTo(MIN_VALUE) == LESS_VALUE) {
                    errors.rejectValue(param, "moneytrans.label.error.moneyless");
                    LOGGER.info(param + " not enough error");
                } else {
                    checkBelongUser(numberAccountFrom, errors);
                }
            }
        }
    }
}
