package by.jum.internetbanking.service.impl;

import by.jum.internetbanking.dao.BankAccountDAO;
import by.jum.internetbanking.entity.BankAccount;
import by.jum.internetbanking.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountDAO accountDAO;

    @Override
    @Transactional
    public void createAccount(BankAccount account) {
        accountDAO.save(account);
    }

    @Override
    @Transactional
    public void deleteAccount(BankAccount account) {
        accountDAO.delete(account);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BankAccount> getAccountList() {
        return accountDAO.getList();
    }

    @Override
    @Transactional(readOnly = true)
    public BankAccount getAccountByID(long accountID) {
        return accountDAO.getByID(accountID);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        accountDAO.deleteByID(id);
    }

    @Override
    @Transactional(readOnly = true)
    public BankAccount getAccountByNumber(String number) {
        return accountDAO.getByNumber(number);
    }

    @Override
    public List<BankAccount> findListAccountsByNumber(String number) {
        return accountDAO.findListByNumber(number);
    }

    @Override
    @Transactional
    public void transferMoney(BankAccount accountFrom, BankAccount accountTo, BigDecimal amountOfTransferredMoney) {
        accountFrom.setAmountOfMoney(accountFrom.getAmountOfMoney().subtract(amountOfTransferredMoney));
        accountTo.setAmountOfMoney(accountTo.getAmountOfMoney().add(amountOfTransferredMoney));
        accountDAO.update(accountFrom);
        accountDAO.update(accountTo);
    }

    @Override
    @Transactional
    public void refillMoney(BigDecimal amountRefillMoney, BankAccount account) {
        account.setAmountOfMoney(account.getAmountOfMoney().add(amountRefillMoney));
        accountDAO.update(account);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BankAccount> getAccountsByUserId(long userID) {
        return accountDAO.getAccountsByUserId(userID);
    }
}