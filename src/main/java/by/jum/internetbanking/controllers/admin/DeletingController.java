package by.jum.internetbanking.controllers.admin;

import by.jum.internetbanking.facade.BankAccountFacade;
import by.jum.internetbanking.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping("/admin")
public class DeletingController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private BankAccountFacade accountFacade;

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = "/users/{id}/accounts/{acoountid}/delete", method = RequestMethod.GET)
    public String deleteAccount(@PathVariable("acoountid") long accountID, @PathVariable("id") long id) {
        accountFacade.deleteAccountByID(accountID);
        return messageSource.getMessage("controller.label.redirectshowusers", new Object[]{id}, Locale.ENGLISH);
    }

    @RequestMapping(value = "users/{id}/delete", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") long id) {
        userFacade.deleteUserByID(id);
        return "redirect:/admin/users";
    }
}
