package by.jum.internetbanking.controllers;

import by.jum.internetbanking.facade.UserFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


@Controller
public class AuthorizationController {

    private final Logger logger = Logger.getLogger(getClass());
    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(required = false) String error) {
        String message = "";
        if (error != null) {
            message = "Invalid username or password, try again !";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return new ModelAndView("redirect:/welcome");
        } else return new ModelAndView("login", "message", message);
    }

    @RequestMapping(value = {"user/authsucces"}, method = RequestMethod.GET)
    public ModelAndView succesAuth() {

        ModelAndView model = new ModelAndView();
        model.addObject("message", "Succes");
        model.setViewName("authSucces");
        return model;

    }

    @RequestMapping(value = {"/user/cards"}, method = RequestMethod.GET)
    public String printCardList(Map<String, Object> map) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        map.put("userCards", userFacade.getUserCardList(userDetails.getUsername()));
        return "userCards";


    }

}
