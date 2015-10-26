package by.jum.internetbanking;


import by.jum.internetbanking.facade.BankAccountFacade;
import by.jum.internetbanking.form.CreateBankAccountForm;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AccountTest {

    @Autowired
    BankAccountFacade accountFacade;

    CreateBankAccountForm accountForm;

    @Before
    public void init() {
        accountForm = new CreateBankAccountForm();
//        accountForm.setAccountNumber(2522);
        accountForm.setAmountOfMoney(500L);

    }

    @Test
    public void addAccount() {
        accountFacade.createAccount(accountForm);
}
    @Test
     public void getList(){
        accountFacade.getAccountList().forEach(accountDTO -> System.out.println(accountDTO.getAmountOfMoney()));
    }
}
