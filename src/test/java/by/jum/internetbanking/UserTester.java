package by.jum.internetbanking;

import by.jum.internetbanking.entity.User;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTester {

    private UserFacade userFacade;

    private User user;

    @Before
    public void init() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

      /*  user = new User();
        user.setFirstName("Yana");
        user.setSurname("3555553");
        user.setSecondName("44");
        user.setPassportNumber("gtrgtrgtr");*/

        userFacade = (UserFacade) applicationContext.getBean("userFacade");
    }

    @Test
    public void getListUser() {
        userFacade.getUserList().forEach(userDTO -> System.out.println(userDTO.getFirstName()));
    }

}
