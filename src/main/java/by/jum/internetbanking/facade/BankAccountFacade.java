package by.jum.internetbanking.facade;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.form.CreateBankAccountForm;

import java.util.List;

public interface BankAccountFacade {
    void createAccount(CreateBankAccountForm accountForm);

    BankAccountDTO getAccountByID(long accountID);

    List<BankAccountDTO> getAccountList();
}