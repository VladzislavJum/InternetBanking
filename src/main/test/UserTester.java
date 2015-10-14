/*package test;

import entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages = {
        "entity", "dao", "service"
})

@ContextConfiguration({
        "/WEB-INF/data.xml",
        "/hibernate.cfg.xml",
        "/applicationContext.xml"
        })

public class UserTester {

    @Autowired
    UserService userService;

    private User user = new User();

    @Before
    public void init() {
        user.setFirstName("Petya");
        user.setSurname("cds");
        user.setSecondName("Ale");
        user.setPassportNumber("grdfdf34567");
    }

    @Test
    public void addUser() {
        userService.addUser(user);
    }
}
*/