package by.jum.internetbanking.controllers.admin;

import by.jum.internetbanking.controllers.AuthorizationController;
import by.jum.internetbanking.facade.BankAccountFacade;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.form.account.CreateBankAccountForm;
import by.jum.internetbanking.form.user.RegistrationUserForm;
import by.jum.internetbanking.form.validator.CreateBankAccountFormValidator;
import by.jum.internetbanking.form.validator.RegistrationUserFormValidator;
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
public class CreatingController {

    private static final Logger LOGGER = Logger.getLogger(AuthorizationController.class);

    @Autowired
    private BankAccountFacade accountFacade;

    @Autowired
    private CreateBankAccountFormValidator accountFormValidator;

    @Autowired
    private RegistrationUserFormValidator userFormValidator;

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = "/signupform", method = RequestMethod.GET)
        public String showRegistrationForm(Model model) {
        model.addAttribute("userForm", new RegistrationUserForm());
        return "/admin/createUser";
    }

    @RequestMapping(value = "/createaccountform", method = RequestMethod.GET)
    public String showCreatingAccountForm(Model model) {
        model.addAttribute("accountForm", new CreateBankAccountForm());
        return "admin/createAccount";
    }

    @RequestMapping(value = "/register", method = {RequestMethod.POST, RequestMethod.GET})
    public String registerUser(@ModelAttribute("userForm") RegistrationUserForm registrationUserForm,
                               final BindingResult result) {
        userFormValidator.validate(registrationUserForm, result);
        if (result.hasErrors()) {
            LOGGER.info("Validation registration error");
            return "admin/createUser";
        }
        userFacade.registerUser(registrationUserForm);
        return "redirect:/admin/users";
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
