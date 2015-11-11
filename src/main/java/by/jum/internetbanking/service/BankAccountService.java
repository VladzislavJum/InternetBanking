package by.jum.internetbanking.service;

import by.jum.internetbanking.entity.BankAccount;

import java.math.BigDecimal;
import java.util.List;

public interface BankAccountService {
    void createAccount(BankAccount account);

    void deleteAccount(BankAccount account);

    List<BankAccount> getAccountList();

    BankAccount getAccountByID(long accountID);

    void deleteById(long id);

    BankAccount getAccountByNumber(String number);

    void transferMoney(BankAccount accountFrom, BankAccount accountTo, BigDecimal amountOfTransferredMoney);

    void refillMoney(BigDecimal amountRefillMoney, BankAccount account);
}
