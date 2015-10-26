package by.jum.internetbanking;

import by.jum.internetbanking.facade.CardFacade;
import by.jum.internetbanking.form.CreateCardForm;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CardTester {

    @Autowired
    private CardFacade cardFacade;

    private CreateCardForm createCardForm;

    @Before
    public void init() {
        createCardForm = new CreateCardForm();
        createCardForm.setPinCode(55454);
        createCardForm.setCardNumber(1414);
    }

    @Test
    public void createCard() {
        cardFacade.createCard(createCardForm);
    }

    @Test public void list(){
        System.out.println(cardFacade.getCardList().get(0).getPinCode());
    }

}
