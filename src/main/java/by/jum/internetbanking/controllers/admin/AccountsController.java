package by.jum.internetbanking.controllers.admin;

import by.jum.internetbanking.facade.BankAccountFacade;
import by.jum.internetbanking.form.money.RefillMoneyForm;
import by.jum.internetbanking.form.validator.RefillMoneyValidator;
import by.jum.internetbanking.json.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

@Controller
@RequestMapping("/admin/users/")
public class AccountsController {
    private static final Logger LOGGER = Logger.getLogger(AccountsController.class);

    @Autowired
    private RefillMoneyValidator moneyValidator;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private BankAccountFacade accountFacade;

    //    TODO: add display error if validation is bad
    @RequestMapping(value = "{id}/accounts/{acoountid}/refill")
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

    @RequestMapping(value = "deleteuseracc", method = RequestMethod.POST)
    @JsonView(Views.Public.class)
    public
    @ResponseBody
    void deleteAcc(@RequestBody long accountID) {
        accountFacade.deleteAccountByID(accountID);
    }
}
