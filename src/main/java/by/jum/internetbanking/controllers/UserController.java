package by.jum.internetbanking.controllers;

import by.jum.internetbanking.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Iterator;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public String showTypesOfPayments(Map<String, Object> map) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Iterator<GrantedAuthority> iterator = (Iterator<GrantedAuthority>) auth.getAuthorities().iterator();
        if ("ROLE_ADMIN".equals(iterator.next().getAuthority())) {
            return "redirect:/admin/signupform";
        }
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        map.put("userAccounts", userFacade.getUserAccountList(userDetails.getUsername()));
        return "user/accounts";
    }

}
