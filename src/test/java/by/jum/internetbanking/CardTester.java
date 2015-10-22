package by.jum.internetbanking;

import by.jum.internetbanking.dto.CardDTO;
import by.jum.internetbanking.facade.CardFacade;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@WebAppConfiguration
public class CardTester {

    @Autowired
    private CardFacade cardFacade;

    private CardDTO cardDTO;

    @Before
    public void init() {

        cardDTO = new CardDTO();
        cardDTO.setPinCode(654);
//        cardDTO.setUserDTO(userFacade.getUserByID(15));

    }

  /* @Test
    public void createCard() {
        cardFacade.createCard(cardDTO);
    }*/

    @Test
    public void getList() {
        System.out.println(cardFacade);
        cardFacade.getCardList().forEach(cardDTO -> System.out.println(cardDTO.getPinCode()));
    }

    /*@Test
    public void getByID() {
        System.out.println(cardFacade.getCardByID(7).getPinCode());
    }*/
}
