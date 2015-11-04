package by.jum.internetbanking.facade;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.form.account.CreateBankAccountForm;

import java.util.List;

public interface BankAccountFacade {
    void createAccount(CreateBankAccountForm accountForm);

    Object getAccountByID(long accountID);

    List<BankAccountDTO> getAccountList();

    void deleteAccountByID(long id);

    BankAccountDTO getAccountByNumber(String searchStr);
}
