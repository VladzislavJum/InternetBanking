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
        account.setBankAccountID(7894L);
        account.setAmountOfMoney(new BigDecimal(999999));
    }

    @Test
    public void testGetList() throws Exception {
        LOGGER.info("ListAccounts: ");
        accountDAO.getList().forEach(account -> LOGGER.info("AccountNumber " + account.getAccountNumber()));
    }

    @Test
    public void testSave() throws Exception {
        accountDAO.save(account);
        LOGGER.info("Created Account with number 7777: " + accountDAO.getByNumber("7777"));
    }

    @Test
    public void testUpdate() throws Exception {
        LOGGER.info("Money Before: " + account.getAmountOfMoney());
        account.setAmountOfMoney(new BigDecimal(1234));
        accountDAO.update(account);
        LOGGER.info("Money After: " + accountDAO.getByID(7894L).getAmountOfMoney());
    }

    @Test
    public void testDelete() throws Exception {
        accountDAO.save(account);
        accountDAO.delete(account);
        LOGGER.info("Deleted Account with number 7777: " + accountDAO.getByNumber("7777"));
    }

    @Test
    public void testGetByID() throws Exception {
        accountDAO.update(account);
        LOGGER.info("Get by id 789456L: " + accountDAO.getByID(7894L));
    }
}