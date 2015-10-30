package by.jum.internetbanking.facade.impl;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.entity.BankAccount;
import by.jum.internetbanking.facade.BankAccountFacade;
import by.jum.internetbanking.form.account.CreateBankAccountForm;
import by.jum.internetbanking.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("accountFacade")
public class BankAccountFacadeImpl implements BankAccountFacade {

    @Autowired
    private BankAccountService accountService;

    @Autowired
    private Converter<CreateBankAccountForm, BankAccount> accountFormToAccountConverter;

    @Autowired
    private Converter<BankAccount, BankAccountDTO> accountToDTOConverter;

    @Autowired
    private Converter<List<BankAccount>, List<BankAccountDTO>> accountListToDTOListConverter;

    @Override
    public void createAccount(CreateBankAccountForm accountForm) {
        accountService.createAccount(accountFormToAccountConverter.convert(accountForm));
    }

    @Override
    public BankAccountDTO getAccountByID(long accountID) {
        return accountToDTOConverter.convert(accountService.getAccountByID(accountID));
    }

    @Override
    public List<BankAccountDTO> getAccountList() {
        List<BankAccountDTO> accountDTOList = accountListToDTOListConverter.convert(accountService.getAccountList());
        return accountDTOList;
    }

    @Override
    public boolean isExistNumber(Integer accountNumber) {
        return accountService.isExistNumber(accountNumber);
    }
}
