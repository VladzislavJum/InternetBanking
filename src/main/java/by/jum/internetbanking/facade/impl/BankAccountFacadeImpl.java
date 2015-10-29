package by.jum.internetbanking.facade.impl;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.entity.BankAccount;
import by.jum.internetbanking.facade.BankAccountFacade;
import by.jum.internetbanking.form.account.CreateBankAccountForm;
import by.jum.internetbanking.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("accountFacade")
public class BankAccountFacadeImpl implements BankAccountFacade {

    @Autowired
    private BankAccountService accountService;

    @Autowired
    private Converter accountFormToAccountConverter;

    @Override
    public void createAccount(CreateBankAccountForm accountForm) {
        accountService.createAccount((BankAccount) accountFormToAccountConverter.convert(accountForm));
    }

    @Override
    public BankAccountDTO getAccountByID(long accountID) {
        return (BankAccountDTO) accountFormToAccountConverter.convert(accountService.getAccountByID(accountID));
    }

    @Override
    public List<BankAccountDTO> getAccountList() {
        List<BankAccountDTO> accountDTOList = new ArrayList<>();
        List<BankAccount> accountList = accountService.getAccountList();

        accountList.forEach(account -> accountDTOList.add((BankAccountDTO) accountFormToAccountConverter.convert(account)));
        return accountDTOList;
    }

    @Override
    public boolean isExistNumber(Integer accountNumber) {
        return accountService.isExistNumber(accountNumber);
    }
}
