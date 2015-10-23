package by.jum.internetbanking;

import by.jum.internetbanking.dto.CardDTO;
import by.jum.internetbanking.entity.Card;
import by.jum.internetbanking.entity.User;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTester {

    private UserFacade userFacade;

    private User user;

    @Before
    public void init() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        userFacade = (UserFacade) applicationContext.getBean("userFacade");
    }

    @Test
    public void getListUser() {
        List<CardDTO> cardList = userFacade.getUserCardList("7");
        cardList.forEach(cardDTO -> System.out.println(cardDTO.getPinCode()));
    }

}
