package by.jum.internetbanking.facade.impl;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.entity.BankAccount;
import by.jum.internetbanking.facade.BankAccountFacade;
import by.jum.internetbanking.facade.converter.BankAccountConverter;
import by.jum.internetbanking.form.account.CreateBankAccountForm;
import by.jum.internetbanking.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("accountFacade")
public class BankAccountFacadeImpl implements BankAccountFacade {

    @Autowired
    BankAccountService accountService;

    @Autowired
    BankAccountConverter accountConverter;

    @Override
    public void createAccount(CreateBankAccountForm accountForm) {
        accountService.createAccount(accountConverter.convertFormToAccount(accountForm));
    }

    @Override
    public BankAccountDTO getAccountByID(long accountID) {
        return accountConverter.convertAccountToDTO(accountService.getAccountByID(accountID));
    }

    @Override
    public List<BankAccountDTO> getAccountList() {
        List<BankAccountDTO> accountDTOList = new ArrayList<>();
        List<BankAccount> accountList = accountService.getAccountList();

        accountList.forEach(account -> accountDTOList.add(accountConverter.convertAccountToDTO(account)));
        return accountDTOList;
    }
}
