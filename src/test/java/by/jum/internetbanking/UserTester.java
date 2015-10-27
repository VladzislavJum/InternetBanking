package by.jum.internetbanking;

import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.form.RegistrationUserForm;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserTester {

    private final Logger LOGGER = Logger.getLogger(UserTester.class);

    @Autowired
    private UserFacade userFacade;

    private RegistrationUserForm form;

    @Before
    public void init() {
            }
    @Test
    public void getListUser() {
        userFacade.getUserList().forEach(userDTO -> LOGGER.warn(userDTO.getLogin()));
    }

    @Test
    public void addUSer() {
        userFacade.registerUser(form);
    }

    @Test
    public void getByID() {
        LOGGER.warn(userFacade.getUserByID(65));
    }

}
