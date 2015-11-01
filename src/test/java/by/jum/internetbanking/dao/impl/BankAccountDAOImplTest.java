package by.jum.internetbanking.dao.impl;

import by.jum.internetbanking.dao.BankAccountDAO;
import by.jum.internetbanking.dao.UserDAO;
import by.jum.internetbanking.entity.BankAccount;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional
public class BankAccountDAOImplTest {
    private final static Logger LOGGER = Logger.getLogger(UserDAOImplTest.class);

    @Autowired
    private BankAccountDAO accountDAO;

    @Test
    public void testGetList() throws Exception {
        LOGGER.info("ListAccounts: ");
        accountDAO.getList().forEach(account -> LOGGER.info("AccountNumber " + account.getAccountNumber()));
    }

    @Test
    public void testSave() throws Exception {
        BankAccount account = new BankAccount();
        account.setAccountNumber(7777);
        account.setBankAccountID(7894L);
        accountDAO.save(account);
        LOGGER.info("Created Account with Nummber 7777");
        accountDAO.getList().forEach(account1 -> LOGGER.info("Number:" +  account.getAccountNumber()));
    }

    @Test
    public void testUpdate() throws Exception {
        BankAccount account = accountDAO.getByID(1L);
        LOGGER.info("Money Before: " + account.getAmountOfMoney());
        account.setAmountOfMoney(new BigDecimal(1234));
        accountDAO.update(account);
        LOGGER.info("Money After: " + accountDAO.getByID(1L).getAmountOfMoney());
    }

    @Test
    public void testDelete() throws Exception {
        accountDAO.delete(accountDAO.getByID(1L));
        LOGGER.info("Deleted Account");
    }

    @Test
    public void testGetByID() throws Exception {
        LOGGER.info("Gey by id 1: AccountNumber " + accountDAO.getByID(1L).getAccountNumber());
    }

    @Test
    public void testIsExistNumber() throws Exception {
        BankAccount account = new BankAccount();
        accountDAO.save(account);
        account.setAccountNumber(9999);
        LOGGER.info("Account with number 9999 exist: "+ accountDAO.isExistNumber(9999));
    }
}