package by.jum.internetbanking;


import by.jum.internetbanking.facade.BankAccountFacade;
import by.jum.internetbanking.form.CreateBankAccountForm;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AccountTest {
    private final Logger LOGGER = Logger.getLogger(getClass());

    @Autowired
    BankAccountFacade accountFacade;

    CreateBankAccountForm accountForm;

    @Before
    public void init() {

    }

    @Test
    public void addAccount() {
        accountFacade.createAccount(accountForm);
}
    @Test
     public void getList(){
        accountFacade.getAccountList().forEach(accountDTO -> LOGGER.info(accountDTO.getAmountOfMoney()));
    }
}
