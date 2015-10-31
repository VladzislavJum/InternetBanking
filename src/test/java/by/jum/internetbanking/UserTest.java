package by.jum.internetbanking;

import by.jum.internetbanking.entity.User;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserTest {

    private final static Logger LOGGER = Logger.getLogger(UserTest.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserFacade userFacade;


    @Before
    public void init() {
    }

    @Test
    public void getListUser() {
        userFacade.getUserList().forEach(userDTO -> LOGGER.info(userDTO.getLogin()));
    }

    @Test
    public void getByID() {
        User user = userService.getUserByID(99L);
        LOGGER.info("User " + user);
    }
}
