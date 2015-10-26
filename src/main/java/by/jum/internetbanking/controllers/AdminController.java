package by.jum.internetbanking.controllers;

import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.form.RegistrationUserForm;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserFacade userFacade;

    @RequestMapping(value = "/signupsucces", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("userForm") RegistrationUserForm registrationUserForm) {

        try {
            userFacade.registerUser(registrationUserForm);
        } catch (ConstraintViolationException e){
            System.out.println(123);
        }

        ModelAndView model = new ModelAndView();
        model.addObject("message", "User " + registrationUserForm.getLogin());
        model.setViewName("signUpSuccess");
        return model;
    }




}
