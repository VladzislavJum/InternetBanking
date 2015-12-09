package by.jum.internetbanking.form.validator;

import by.jum.internetbanking.form.money.MoneyTransactionForm;
import by.jum.internetbanking.service.BankAccountService;
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
public class MoneyTransactionValidator implements Validator {

    private static final Logger LOGGER = Logger.getLogger(MoneyTransactionValidator.class);

    private static final int LESS_VALUE = -1;
    private static final int MIN_VALUE = 100;

    private Pattern pattern;
    private Matcher matcher;

    @Autowired
    private BankAccountService accountService;

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return MoneyTransactionForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MoneyTransactionForm transactionForm = (MoneyTransactionForm) target;
        String numberAccountFrom = transactionForm.getNumberAccountFrom();
        if (StringUtils.isEmpty(numberAccountFrom)) {
            errors.rejectValue("numberAccountFrom", "moneytrans.label.error.requiredaccount");
            LOGGER.info("empty numberAccountFrom error");
        } else if (numberAccountFrom.length() > 10 || numberAccountFrom.length() < 4) {
            errors.rejectValue("numberAccountFrom", "createaccount.label.error.accountnumbersize");
            LOGGER.info("size numberAccountFrom error");
        } else {
            pattern = Pattern.compile(ValidationConstants.PASSPORT_NUMBER_LOGIN_PASS_PATTERN.getPattern());
            matcher = pattern.matcher(numberAccountFrom);
            if (!matcher.matches()) {
                errors.rejectValue("numberAccountFrom", "common.label.error.numericletters");
                LOGGER.info("content numberAccountFrom error");
            } else if (accountService.getAccountByNumber(numberAccountFrom) == null) {
                errors.rejectValue("numberAccountFrom", "searchaccount.label.error.accountnotexist");
                LOGGER.info("numberAccountFrom not exist error");
            } else {
                checkAccountNumberTo(transactionForm, errors, "objectTo");
            }
        }
    }

    private void checkBelongUser(String numberAccountFrom, Errors errors) {
        if (accountService.getAccountByNumber(numberAccountFrom).getUser().getUserID() != userService.getIDCurrentUser()) {
            errors.rejectValue("numberAccountFrom", "moneytrans.label.error.belong");
            LOGGER.info("not belong user error");
        }
    }

    private void checkAccountNumberTo(MoneyTransactionForm transactionForm, Errors errors, String param) {
        String accountNumberTo = transactionForm.getObjectTo();
        String accountNumberFrom = transactionForm.getNumberAccountFrom();

        if (StringUtils.isEmpty(accountNumberTo)) {
            errors.rejectValue(param, "common.label.error.emptyfield");
            LOGGER.info("empty objectTo error");
        } else if (accountNumberTo.length() > 10 || accountNumberTo.length() < 4) {
            errors.rejectValue(param, "createaccount.label.error.accountnumbersize");
            LOGGER.info("size objectTo error");
        } else {
            pattern = Pattern.compile(ValidationConstants.PASSPORT_NUMBER_LOGIN_PASS_PATTERN.getPattern());
            matcher = pattern.matcher(accountNumberTo);
            if (!matcher.matches()) {
                errors.rejectValue(param, "common.label.error.numericletters");
                LOGGER.info("content objectTo error");
            } else if (accountService.getAccountByNumber(accountNumberTo) == null) {
                errors.rejectValue(param, "searchaccount.label.error.accountnotexist");
                LOGGER.info("objectTo not exist error");
            } else if (accountNumberTo.equals(accountNumberFrom)) {
                errors.rejectValue(param, "moneytrans.label.error.equalsacc");
                LOGGER.info("equals accounts error");
            } else {
                checkAmountOfMoney(transactionForm.getAmountOfTransferredMoney(), accountNumberFrom, errors, "amountOfTransferredMoney");
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
            pattern = Pattern.compile(ValidationConstants.NUMBER_PATTERN.getPattern());
            matcher = pattern.matcher(amountOfMoney);
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
}
