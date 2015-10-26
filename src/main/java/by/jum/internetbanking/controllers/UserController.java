package by.jum.internetbanking.controllers;

import by.jum.internetbanking.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = "/authsucces", method = RequestMethod.GET)
    public ModelAndView succesAuth() {

        ModelAndView model = new ModelAndView();
        model.addObject("message", "Succes");
        model.setViewName("authSucces");
        return model;

    }

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public String showTypesOfPayments(Map<String, Object> map){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        map.put("userAccounts", userFacade.getUserAccountList(userDetails.getUsername()));
        return "user/accounts";
    }

}
