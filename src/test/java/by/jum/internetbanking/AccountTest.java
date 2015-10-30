package by.jum.internetbanking;


import by.jum.internetbanking.facade.BankAccountFacade;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AccountTest {
    private final static Logger LOGGER = Logger.getLogger(AccountTest.class);

    @Autowired
    BankAccountFacade accountFacade;


    @Test
    public void isExist(){
        StringBuilder stringBuilder = new StringBuilder("exist account: ");
        LOGGER.info(stringBuilder.append(accountFacade.isExistNumber(132454)));
    }

    @Test
    public void getList(){
        accountFacade.getAccountList().forEach(accountDTO -> LOGGER.info(accountDTO.getAccountNumber()));
    }
}
