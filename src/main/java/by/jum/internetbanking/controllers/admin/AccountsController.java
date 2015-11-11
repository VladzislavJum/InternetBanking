package by.jum.internetbanking.controllers.admin;

import by.jum.internetbanking.facade.BankAccountFacade;
import by.jum.internetbanking.form.money.RefillMoneyForm;
import by.jum.internetbanking.form.validator.RefillMoneyValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping("/admin")
public class AccountsController {

    private static final Logger LOGGER = Logger.getLogger(AccountsController.class);

    @Autowired
    private RefillMoneyValidator moneyValidator;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private BankAccountFacade accountFacade;

    @RequestMapping(value = "/users/{id}/accounts/{acoountid}/delete", method = RequestMethod.GET)
    public String deleteAccount(@PathVariable("acoountid") long accountID, @PathVariable("id") long id) {
        accountFacade.deleteAccountByID(accountID);
        return messageSource.getMessage("controller.label.redirectshowusersaccounts", new Object[]{id}, Locale.ENGLISH);
    }

    //    TODO: add display error if validation is bad
    @RequestMapping(value = "users/{id}/accounts/{acoountid}/refill")
    public String refill(@ModelAttribute("refillForm") RefillMoneyForm refillMoneyForm,
                         @PathVariable("acoountid") long accountID, @PathVariable("id") long id, final BindingResult result) {
        moneyValidator.validate(refillMoneyForm, result);
        if (!result.hasErrors()) {
            accountFacade.refillMoney(refillMoneyForm, accountID);
        } else {
            LOGGER.info("Validation refill Money error");
        }
        return messageSource.getMessage("controller.label.redirectshowusersaccounts", new Object[]{id}, Locale.ENGLISH);
    }
}