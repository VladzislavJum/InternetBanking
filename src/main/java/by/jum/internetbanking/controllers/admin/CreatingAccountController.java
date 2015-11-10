package by.jum.internetbanking.controllers.admin;

import by.jum.internetbanking.facade.BankAccountFacade;
import by.jum.internetbanking.form.account.CreateBankAccountForm;
import by.jum.internetbanking.form.history.PaymentHistoryForm;
import by.jum.internetbanking.form.validator.CreateBankAccountFormValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class CreatingAccountController {

    private static final Logger LOGGER = Logger.getLogger(CreatingAccountController.class);

    @Autowired
    private BankAccountFacade accountFacade;

    @Autowired
    private CreateBankAccountFormValidator accountFormValidator;

    @RequestMapping(value = "/createaccountform", method = RequestMethod.GET)
    public String showCreatingAccountForm(Model model) {
        model.addAttribute("accountForm", new CreateBankAccountForm());
        return "admin/createAccount";
    }

    @RequestMapping(value = "/createaccount", method = {RequestMethod.POST, RequestMethod.GET})
    public String createAccount(@ModelAttribute("accountForm") CreateBankAccountForm accountForm,
                                final BindingResult result) {
        accountFormValidator.validate(accountForm, result);
        if (result.hasErrors()) {
            LOGGER.info("Validation createAccount error");
            return "admin/createAccount";
        }
        accountFacade.createAccount(accountForm);
        return "admin/createdSuccess";
    }
}
