package by.jum.internetbanking;

import by.jum.internetbanking.facade.CardFacade;
import by.jum.internetbanking.form.CreateCardForm;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@WebAppConfiguration*/
public class CardTester {

    private CardFacade cardFacade;
    private CreateCardForm createCardForm;

    @Before
    public void init() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        cardFacade = (CardFacade) applicationContext.getBean("cardFacade");

        createCardForm = new CreateCardForm();
        createCardForm.setPinCode(5555);
        createCardForm.setCardNumber(111);
    }

    @Test
    public void createCard() {
        cardFacade.createCard(createCardForm);
    }

}
