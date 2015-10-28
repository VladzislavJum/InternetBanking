package by.jum.internetbanking;


import by.jum.internetbanking.facade.BankAccountFacade;
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
/*
    @Valid
    CreateBankAccountForm accountForm;

    public static void validate(Object object, Validator validator) {
        Set<ConstraintViolation<Object>> constraintViolations = validator
                .validate(object);

        System.out.println(object);
        System.out.println(String.format("Number Errors: %d",
                constraintViolations.size()));

        for (ConstraintViolation<Object> cv : constraintViolations)
            System.out.println(String.format(
                    "Error property: [%s], value: [%s], message: [%s]",
                    cv.getPropertyPath(), cv.getInvalidValue(), cv.getMessage()));
    }*/
/*
    @Test
    public void addAccount() {
        accountFacade.createdSuccess(accountForm);
}
    @Test
     public void getList(){
        accountFacade.getAccountList().forEach(accountDTO -> LOGGER.info(accountDTO.getAmountOfMoney()));
    }*/

    @Before
    public void init() {


    }

    @Test
    public void valid() {
       /* accountForm = new CreateBankAccountForm();
        accountForm.setAccountNumber("464894874");

        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();

        validate(accountForm, validator);
*/

    }


}
