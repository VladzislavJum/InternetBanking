package by.jum.internetbanking.controllers;

import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.form.RegistrationUserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class RegistrationUserController {

    @Autowired
    UserFacade userFacade;

    @RequestMapping(value = "/signupsucces", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("userForm") RegistrationUserForm registrationUserForm) {
        userFacade.registerUser(registrationUserForm);

        ModelAndView model = new ModelAndView();
        model.addObject("message", "You are " + registrationUserForm.getLogin());
        model.setViewName("signUpSuccess");
        return model;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String showRegistrationForm(Map<String, Object> map) {
        map.put("userForm", new RegistrationUserForm());
        return "registerUser";
    }

}
