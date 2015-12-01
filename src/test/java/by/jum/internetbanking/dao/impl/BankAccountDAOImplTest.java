package by.jum.internetbanking.dao.impl;

import by.jum.internetbanking.dao.BankAccountDAO;
import by.jum.internetbanking.entity.BankAccount;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional
public class BankAccountDAOImplTest {
    private final static Logger LOGGER = Logger.getLogger(UserDAOImplTest.class);

    @Autowired
    private BankAccountDAO accountDAO;

    private BankAccount account;

    @Before
    public void init() {
        LOGGER.info("init Test");
        account = new BankAccount();
        account.setAccountNumber("7777");
        account.setAmountOfMoney(new BigDecimal(999999));
        accountDAO.save(account);
    }

    @Test
    public void testSave() throws Exception {
        LOGGER.info("Created Account with number 7777 is " + accountDAO.getByNumber("7777"));
    }

    @Test
    public void testUpdate() throws Exception {
        LOGGER.info("Money Before: " + account.getAmountOfMoney());
        account.setAmountOfMoney(new BigDecimal(1234));
        accountDAO.update(account);
        LOGGER.info("Money After: " + accountDAO.getByID(account.getBankAccountID()).getAmountOfMoney());
    }

    @Test
    public void testDelete() throws Exception {
        accountDAO.delete(account);
        LOGGER.info("Test: Deleted Account with number 7777 is " + accountDAO.getByID(account.getBankAccountID()));
    }

    @Test
    public void testGetByID() throws Exception {
        LOGGER.info("Test: Get Account by id: " + accountDAO.getByID(account.getBankAccountID()));
    }

    @Test
    public void testDeleteByID() throws Exception {
        accountDAO.deleteByID(account.getBankAccountID());
        LOGGER.info("Test: deleteByID: account is " + accountDAO.getByID(account.getBankAccountID()));
    }
}