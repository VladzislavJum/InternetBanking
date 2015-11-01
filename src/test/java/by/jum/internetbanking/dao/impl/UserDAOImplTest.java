package by.jum.internetbanking.dao.impl;

import by.jum.internetbanking.dao.UserDAO;
import by.jum.internetbanking.entity.User;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional
public class UserDAOImplTest {
    private final static Logger LOGGER = Logger.getLogger(UserDAOImplTest.class);

    @Autowired
    private UserDAO userDAO;

    @Test
    public void testGetList() throws Exception {
        LOGGER.info("ListUsers: ");
        userDAO.getList().forEach(user -> LOGGER.info("Login" + user.getLogin()));
    }

    @Test
    public void testDelete() throws Exception {
        userDAO.delete(userDAO.getByUserName("vjum"));
    }

    @Test
    public void testUpdate() throws Exception {
        User user = userDAO.getByUserName("vjum");
        user.setPassportNumber("1234567");
        userDAO.update(user);
        LOGGER.info("Updating passportNumber" + userDAO.getByUserName("vjum").getPassportNumber());
    }

    @Test
    public void testSave() throws Exception {
        User user = new User();
        user.setLogin("testUser");
        userDAO.save(user);
        LOGGER.info("Created User: " + userDAO.getByUserName("testUser").getLogin());
    }

    @Test
    public void testGetById() throws Exception {
        LOGGER.info("Get by ID = 1: Login " + userDAO.getById(1L).getLogin());
    }

    @Test
    public void testGetByUserName() throws Exception {
        LOGGER.info("Get By UserName(vjum): Firstname" + userDAO.getByUserName("vjum").getFirstname());
    }

    @Test
    public void testGetAccountUserList() throws Exception {
        LOGGER.info("NumberAccounts: ");
        userDAO.getAccountUserList("vjum").forEach(account -> LOGGER.info(account.getAccountNumber()));
    }
    }
