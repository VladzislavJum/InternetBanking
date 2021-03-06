package by.jum.internetbanking.facade;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.form.account.CreateBankAccountForm;
import by.jum.internetbanking.form.money.MoneyTransactionForm;
import by.jum.internetbanking.form.money.RefillMoneyForm;

import java.util.List;

public interface BankAccountFacade {
    void createAccount(CreateBankAccountForm accountForm);

    BankAccountDTO getAccountByID(long accountID);

    List<BankAccountDTO> getAccountList();

    void deleteAccountByID(long id);

    BankAccountDTO getAccountByNumber(String searchStr);

    List<BankAccountDTO> findListAccountsByNumber(String number);

    void transferMoney(MoneyTransactionForm moneyTransactionForm);

    void refillMoney(RefillMoneyForm refillMoneyForm, long accountID);
}
