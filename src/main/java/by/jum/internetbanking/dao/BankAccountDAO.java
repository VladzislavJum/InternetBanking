package by.jum.internetbanking.dao;

import by.jum.internetbanking.entity.BankAccount;

import java.util.List;

public interface BankAccountDAO {
    List<BankAccount> getList();

    void save(BankAccount account);

    void update(BankAccount account);

    void delete(BankAccount account);

    BankAccount getByID(Long id);

    boolean isExistNumber(Integer accountNumber);
}
