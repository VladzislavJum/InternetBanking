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
    private UserDAO userDAO;

    @Autowired
    BankAccountDAO accountDAO;

    private User user;

    @Before
    public void init() {
        user = new User();
        LOGGER.info("init Test");
        user.setUserID(321L);
        user.setLogin("testUser");
        user.setPassportNumber("testNumber");
    }

    @Test
    public void testGetList() throws Exception {
        LOGGER.info("ListUsers: ");
        userDAO.getList().forEach(user -> LOGGER.info("Login" + user.getLogin()));
    }

    @Test
    public void testDelete() throws Exception {
        userDAO.save(user);
        userDAO.delete(user);
        LOGGER.info("Delete user, exist: " + userDAO.getByUserName("testUser"));
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
        userDAO.save(user);
        LOGGER.info("Created User: " + userDAO.getByUserName("testUser").getLogin());
    }

    @Test
    public void testGetById() throws Exception {
        userDAO.save(user);
        LOGGER.info("Get by ID = 111111: Login " + userDAO.getById(user.getUserID()).getLogin());
    }

    @Test
    public void testGetByUserName() throws Exception {
        userDAO.save(user);
        LOGGER.info("Get By UserName(testUser): PassportNumber " + userDAO.getByUserName("testUser").getPassportNumber());
    }

    @Test
    public void testGetAccountUserList() throws Exception {
        userDAO.save(user);
        LOGGER.info("NumberAccounts: ");
        List<BankAccount> accountList = accountDAO.getAccountsByUserId(user.getUserID());
        if (accountList != null){
            accountList.forEach(account -> LOGGER.info(account));
        } else {
            LOGGER.info("List is null");
        }
    }

    @Test
    public void testDeleteByID() throws Exception {
        userDAO.save(user);
        userDAO.deleteByID(user.getUserID());
        LOGGER.info("Test: deleteByID: user is " + userDAO.getById(user.getUserID()));
    }
}
