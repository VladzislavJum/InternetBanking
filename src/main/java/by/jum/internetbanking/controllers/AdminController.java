package by.jum.internetbanking.controllers;

import by.jum.internetbanking.facade.BankAccountFacade;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.form.CreateBankAccountForm;
import by.jum.internetbanking.form.RegistrationUserForm;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final Logger LOGGER = Logger.getLogger(getClass());

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private BankAccountFacade accountFacade;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String showRegistrationForm(Map<String, Object> map) {
        map.put("userForm", new RegistrationUserForm());
        return "/admin/createUser";
    }

    @RequestMapping(value = "/createaccount", method = RequestMethod.GET)
    public String showCreatingAccountForm(Map<String, Object> map) {
        map.put("accountForm", new CreateBankAccountForm());
        return "admin/createAccount";
    }

    @RequestMapping(value = "/signupsucces", method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute("userForm") RegistrationUserForm registrationUserForm) {
        userFacade.registerUser(registrationUserForm);

        ModelAndView model = new ModelAndView();
        model.addObject("firstName", registrationUserForm.getFirstName());
        model.addObject("surname", registrationUserForm.getSurname());
        model.addObject("lastName", registrationUserForm.getLastName());
        model.addObject("passportNumber", registrationUserForm.getPassportNumber());
        model.addObject("login", registrationUserForm.getLogin());

        model.setViewName("admin/signUpSuccess");
        return model;
    }

    @RequestMapping(value = "/createdsucces", method = RequestMethod.POST)
    public ModelAndView createAccount(@ModelAttribute("accountForm") CreateBankAccountForm accountForm) {
        accountFacade.createAccount(accountForm);

        ModelAndView model = new ModelAndView();
        model.addObject("message", "Account " + accountForm.getAccountNumber());
        model.setViewName("admin/createdSuccess");
        return model;
    }

}
