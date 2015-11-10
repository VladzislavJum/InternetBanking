package by.jum.internetbanking.controllers.admin;

import by.jum.internetbanking.facade.BankAccountFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping("/admin")
public class AccountsController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private BankAccountFacade accountFacade;

    @RequestMapping(value = "/users/{id}/accounts/{acoountid}/delete", method = RequestMethod.GET)
    public String deleteAccount(@PathVariable("acoountid") long accountID, @PathVariable("id") long id) {
        accountFacade.deleteAccountByID(accountID);
        return messageSource.getMessage("controller.label.redirectshowusers", new Object[]{id}, Locale.ENGLISH);
    }
}
