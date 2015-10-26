package by.jum.internetbanking.service;

import by.jum.internetbanking.entity.BankAccount;

import java.util.List;

public interface BankAccountService {
    void createAccount(BankAccount account);

    void deleteAccount(BankAccount account);

    List<BankAccount> getAccountList();

    BankAccount getAccountByID(long accountID);
}
