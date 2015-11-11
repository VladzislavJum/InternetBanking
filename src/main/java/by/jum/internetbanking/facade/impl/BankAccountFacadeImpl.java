package by.jum.internetbanking.facade.impl;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.entity.BankAccount;
import by.jum.internetbanking.facade.BankAccountFacade;
import by.jum.internetbanking.form.account.CreateBankAccountForm;
import by.jum.internetbanking.form.money.MoneyTransactionForm;
import by.jum.internetbanking.form.money.RefillMoneyForm;
import by.jum.internetbanking.service.BankAccountService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

@Component
public class BankAccountFacadeImpl implements BankAccountFacade {

    private static final Logger LOGGER = Logger.getLogger(BankAccountFacadeImpl.class);

    @Autowired
    private BankAccountService accountService;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private MessageSource messageSource;

    @Override
    public void createAccount(CreateBankAccountForm accountForm) {
        LOGGER.info("Facade: Creating Account");
        accountService.createAccount(conversionService.convert(accountForm, BankAccount.class));
    }

    @Override
    public BankAccountDTO getAccountByID(long accountID) {
        LOGGER.info("Facade: getAccount by ID");
        return conversionService.convert(accountService.getAccountByID(accountID), BankAccountDTO.class);
    }

    @Override
    public List<BankAccountDTO> getAccountList() {
        TypeDescriptor sourceType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(BankAccount.class));
        TypeDescriptor targetType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(BankAccountDTO.class));
        List<BankAccountDTO> accountDTOList = (List<BankAccountDTO>) conversionService.
                convert(accountService.getAccountList(), sourceType, targetType);
        return accountDTOList;
    }

    @Override
    public void deleteAccountByID(long id) {
        LOGGER.info("Facade: Deleting Account");
        accountService.deleteById(id);
    }

    @Override
    public BankAccountDTO getAccountByNumber(String number) {
        LOGGER.info("Facade: getAccount by Number");
        BankAccount account = accountService.getAccountByNumber(number);
        if (account != null) {
            return conversionService.convert(account, BankAccountDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public void transferMoney(MoneyTransactionForm moneyTransactionForm) {
        String numberAccountFrom = moneyTransactionForm.getNumberAccountFrom();
        String numberAccountTo = moneyTransactionForm.getNumberAccountTo();
        String amountOfTransferredMoney = moneyTransactionForm.getAmountOfTransferredMoney();

        BigDecimal transferredMoney = new BigDecimal(amountOfTransferredMoney);
        BankAccount accountFrom = accountService.getAccountByNumber(numberAccountFrom);
        BankAccount accountTo = accountService.getAccountByNumber(numberAccountTo);

        LOGGER.info(messageSource.getMessage("print.transfer", new Object[]{amountOfTransferredMoney,
                numberAccountFrom, numberAccountTo}, Locale.ENGLISH));
        accountService.transferMoney(accountFrom, accountTo, transferredMoney);
    }

    @Override
    public void refillMoney(RefillMoneyForm refillMoneyForm, long accountID) {
        String refillMoney = refillMoneyForm.getAmountOfMoney();
        BankAccount account = accountService.getAccountByID(accountID);
        LOGGER.info("Facade: Amount of Refilling money: " + refillMoney);

        BigDecimal amountRefillMoney = new BigDecimal(refillMoney);
        accountService.refillMoney(amountRefillMoney, account);
    }
}
