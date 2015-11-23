package by.jum.internetbanking.dao;

import by.jum.internetbanking.entity.BankAccount;

import java.util.List;

public interface BankAccountDAO {
    List<BankAccount> getList();

    void save(BankAccount account);

    void update(BankAccount account);

    void delete(BankAccount account);

    void deleteByID(long id);

    BankAccount getByID(Long id);

    BankAccount getByNumber(String number);

    List<BankAccount> getAccountsByUserId(long userID);
}
