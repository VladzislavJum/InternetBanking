package by.jum.internetbanking.controllers;

import by.jum.internetbanking.entity.User;
import by.jum.internetbanking.facade.BankAccountFacade;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.form.CreateBankAccountForm;
import by.jum.internetbanking.form.RegistrationUserForm;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final Logger LOGGER = Logger.getLogger(getClass());

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private BankAccountFacade accountFacade;

    @RequestMapping(value = "/signupform", method = RequestMethod.GET)
    public String showRegistrationForm(Map<String, Object> map) {
        map.put("userForm", new RegistrationUserForm());
        return "/admin/createUser";
    }

    @RequestMapping(value = "/createaccountform", method = RequestMethod.GET)
    public ModelAndView showCreatingAccountForm(@RequestParam(required = false) String error) {
        ModelAndView model = new ModelAndView();
        String message = "";
        if (error != null) {
            message = messageSource.getMessage("createaccountform.label.notexist", null, LocaleContextHolder.getLocale());
        }
        model.addObject("message", message);
        model.addObject("accountForm", new CreateBankAccountForm());
        model.setViewName("admin/createAccount");
        return model;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("userForm") RegistrationUserForm registrationUserForm, HttpServletRequest request) {
        userFacade.registerUser(registrationUserForm);
        request.getSession().setAttribute("userForm", registrationUserForm);
        return "redirect:/admin/signupsuccess";
    }

    @RequestMapping(value = "/createaccount", method = RequestMethod.POST)
    public String createaccount(@ModelAttribute("accountForm") CreateBankAccountForm accountForm, HttpServletRequest request) {
        User user = userFacade.getUserByUserName(accountForm.getUserLogin());
        if (null != user) {
            accountFacade.createAccount(accountForm);
            request.getSession().setAttribute("accountForm", accountForm);
            return "redirect:/admin/createdsuccess";
        } else {
            return "redirect:/admin/createaccountform?error";
        }
    }

    @RequestMapping(value = "/signupsuccess", method = RequestMethod.GET)
    public ModelAndView showInfUser(HttpServletRequest request) {

        RegistrationUserForm registrationUserForm = (RegistrationUserForm) request.getSession().getAttribute("userForm");
        ModelAndView model = new ModelAndView();
        model.addObject("firstName", registrationUserForm.getFirstname());
        model.addObject("surname", registrationUserForm.getSurname());
        model.addObject("lastName", registrationUserForm.getLastname());
        model.addObject("passportNumber", registrationUserForm.getPassportNumber());
        model.addObject("login", registrationUserForm.getLogin());

        model.setViewName("admin/signUpSuccess");
        return model;
    }

    @RequestMapping(value = "/createdsuccess", method = RequestMethod.GET)
    public ModelAndView createAccount(HttpServletRequest request) {

        CreateBankAccountForm accountForm = (CreateBankAccountForm) request.getSession().getAttribute("accountForm");
        ModelAndView model = new ModelAndView();
        model.addObject("accountNumber", accountForm.getAccountNumber());
        model.addObject("amountOfMoney", accountForm.getAmountOfMoney());
        model.addObject("userLogin", accountForm.getUserLogin());

        model.setViewName("admin/createdSuccess");
        return model;
    }
}
