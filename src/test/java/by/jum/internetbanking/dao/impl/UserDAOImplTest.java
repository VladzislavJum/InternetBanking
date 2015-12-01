package by.jum.internetbanking.dao.impl;

import by.jum.internetbanking.dao.BankAccountDAO;
import by.jum.internetbanking.dao.UserDAO;
import by.jum.internetbanking.entity.BankAccount;
import by.jum.internetbanking.entity.User;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional
public class UserDAOImplTest {
    private final static Logger LOGGER = Logger.getLogger(UserDAOImplTest.class);
    @Autowired
    BankAccountDAO accountDAO;
    @Autowired
    private UserDAO userDAO;
    private User user;
    private EmbeddedDatabase db;

    @Before
    public void init() {
        LOGGER.info("init Test");
        user = new User();
        user.setLogin("testUser");
        user.setPassportNumber("testNumber");
        userDAO.save(user);
    }

    @Test
    public void testDelete() throws Exception {
        userDAO.delete(user);
        LOGGER.info("Delete user: " + userDAO.getById(user.getUserID()));
    }

    @Test
    public void testUpdate() throws Exception {
        LOGGER.info("PassportNumber before: " + user.getPassportNumber());
        user.setPassportNumber("1234567");
        userDAO.update(user);
        LOGGER.info("Updating passportNumber " + userDAO.getById(user.getUserID()).getPassportNumber());
    }

    @Test
    public void testSave() throws Exception {
        LOGGER.info("Created User: " + userDAO.getById(user.getUserID()));
    }

    @Test
    public void testGetById() throws Exception {
        LOGGER.info("GetByID: Login " + userDAO.getById(user.getUserID()));
    }

    @Test
    public void testGetByUserName() throws Exception {
        LOGGER.info("Get By UserName(testUser): " + userDAO.getByUserName("testUser"));
    }

    @Test
    public void testGetAccountUserList() throws Exception {
        LOGGER.info("NumberAccounts: ");
        List<BankAccount> accountList = accountDAO.getAccountsByUserId(user.getUserID());
        if (accountList != null) {
            accountList.forEach(account -> LOGGER.info(account));
        } else {
            LOGGER.info("List is null");
        }
    }

    @Test
    public void testDeleteByID() throws Exception {
        userDAO.deleteByID(user.getUserID());
        LOGGER.info("Test: deleteByID: user is " + userDAO.getById(user.getUserID()));
    }
}
