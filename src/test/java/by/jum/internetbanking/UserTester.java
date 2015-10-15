package by.jum.internetbanking;

import by.jum.internetbanking.entity.User;
import by.jum.internetbanking.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTester {

    private UserService userService;

    private User user;

    @Before
    public void init() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        user = new User();
        user.setFirstName("aaa");
        user.setSurname("33");
        user.setSecondName("44");
        user.setPassportNumber("dvdv");

        userService = (UserService) applicationContext.getBean("userService");


    }

    @Test
    public void addUser() {
        userService.registerUser(user);
    }
}
