package by.jum.internetbanking.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AuthorizationController {

    private final Logger logger = Logger.getLogger(getClass());

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = {"/authsucces"}, method = RequestMethod.GET)
    public ModelAndView succesAuthPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("message", "Succes");
        model.setViewName("authSucces");
        return model;

    }

}
