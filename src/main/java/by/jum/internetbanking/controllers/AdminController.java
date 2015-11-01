package by.jum.internetbanking.controllers;

import by.jum.internetbanking.facade.BankAccountFacade;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.form.account.CreateBankAccountForm;
import by.jum.internetbanking.form.user.RegistrationUserForm;
import by.jum.internetbanking.form.validator.CreateBankAccountFormValidator;
import by.jum.internetbanking.form.validator.RegistrationUserFormValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private BankAccountFacade accountFacade;

    @Autowired
    private CreateBankAccountFormValidator accountFormValidator;

    @Autowired
    private RegistrationUserFormValidator userFormValidator;


    @RequestMapping(value = "/signupform", method = RequestMethod.GET)
    public String showRegistrationForm(Map<String, Object> map) {
        map.put("userForm", new RegistrationUserForm());
        return "/admin/createUser";
    }

    @RequestMapping(value = "/createaccountform", method = RequestMethod.GET)
    public String showCreatingAccountForm(Map<String, Object> map) {
        map.put("accountForm", new CreateBankAccountForm());
        return "admin/createAccount";
    }

    @RequestMapping(value = "/register", method = {RequestMethod.POST, RequestMethod.GET})
    public String registerUser(@ModelAttribute("userForm") RegistrationUserForm registrationUserForm,
                               final BindingResult result) {
        userFormValidator.validate(registrationUserForm, result);
        if (result.hasErrors()) {
            return "admin/createUser";
        }
        userFacade.registerUser(registrationUserForm);
        return "admin/signUpSuccess";
    }

    @RequestMapping(value = "/createaccount", method = {RequestMethod.POST, RequestMethod.GET})
    public String createAccount(@ModelAttribute("accountForm") CreateBankAccountForm accountForm,
                                final BindingResult result) {
        accountFormValidator.validate(accountForm, result);
        if (result.hasErrors()) {
            return "admin/createAccount";
        }
        accountFacade.createAccount(accountForm);
        return "admin/createdSuccess";
    }
}
