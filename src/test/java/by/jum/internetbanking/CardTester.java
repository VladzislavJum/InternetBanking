package by.jum.internetbanking;

import by.jum.internetbanking.dto.CardDTO;
import by.jum.internetbanking.facade.CardFacade;
import by.jum.internetbanking.facade.UserFacade;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CardTester {

    private CardFacade cardFacade;

    private CardDTO cardDTO;

    @Before
    public void init() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        cardDTO = new CardDTO();
        cardDTO.setPinCode(654);
//        cardDTO.setUserDTO(userFacade.getUserByID(15));

        cardFacade = (CardFacade) applicationContext.getBean("cardFacade");

    }

  /* @Test
    public void createCard() {
        cardFacade.createCard(cardDTO);
    }*/

    @Test
    public void getList(){
        cardFacade.getCardList().forEach(cardDTO -> System.out.println(cardDTO.getPinCode()));
    }

    /*@Test
    public void getByID() {
        System.out.println(cardFacade.getCardByID(7).getPinCode());
    }*/
}
