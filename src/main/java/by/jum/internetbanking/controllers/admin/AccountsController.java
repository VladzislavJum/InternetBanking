package by.jum.internetbanking.controllers.admin;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.facade.BankAccountFacade;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.form.money.RefillMoneyForm;
import by.jum.internetbanking.form.validator.RefillMoneyValidator;
import by.jum.internetbanking.json.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("admin/users")
public class AccountsController {
    private static final Logger LOGGER = Logger.getLogger(AccountsController.class);

    @Autowired
    private RefillMoneyValidator moneyValidator;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private BankAccountFacade accountFacade;

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = "/{id}/accounts/{acoountid}/refill", method = {RequestMethod.POST, RequestMethod.GET})
    public String refill(@ModelAttribute("refillForm") RefillMoneyForm refillMoneyForm, Model model,
                         @PathVariable("acoountid") long accountID, @PathVariable("id") long id, final BindingResult result) {
        moneyValidator.validate(refillMoneyForm, result);
        if (result.hasErrors()) {
            LOGGER.info("Validation refillMoney error");
            List<BankAccountDTO> accountDTOList = userFacade.getUserAccountList(id);
            model.addAttribute("accountList", accountDTOList);
            model.addAttribute("user", userFacade.getUserByID(id));
            model.addAttribute("refillForm", refillMoneyForm);
            model.addAttribute("accID", accountID);
            return "admin/showAccounts";
        }
        accountFacade.refillMoney(refillMoneyForm, accountID);
        return messageSource.getMessage("controller.label.redirectshowusersaccounts", new Object[]{id}, Locale.ENGLISH);
    }

    @RequestMapping(value = "/{id}/accounts", method = RequestMethod.GET)
    public String showUserAccounts(@PathVariable("id") long id, Model model) {
        List<BankAccountDTO> accountDTOList = userFacade.getUserAccountList(id);
        model.addAttribute("accountList", accountDTOList);
        model.addAttribute("user", userFacade.getUserByID(id));
        model.addAttribute("refillForm", new RefillMoneyForm());
        LOGGER.error(userFacade.getUserAccountList(id));
        if (userFacade.getUserByID(id) == null) {
            String message = messageSource.getMessage("searchaccount.label.error.usernotexist", null, LocaleContextHolder.getLocale());
            model.addAttribute("notExist", message);
        } else if (userFacade.getUserAccountList(id).size() == 0) {
            String message = messageSource.getMessage("showaccounts.label.error.notaccs", null, LocaleContextHolder.getLocale());
            model.addAttribute("notExist", message);
        }
        return "admin/showAccounts";
    }

    @RequestMapping(value = "/deleteuseracc", method = RequestMethod.POST)
    @JsonView(Views.Account.class)
    public
    @ResponseBody
    void deleteAcc(@RequestBody long accountID) {
        accountFacade.deleteAccountByID(accountID);
    }
}
