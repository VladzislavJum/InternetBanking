package by.jum.internetbanking.controllers;

import by.jum.internetbanking.Roles;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.service.RoleService;
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

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public String showTypesOfPayments(Map<String, Object> map) {
        if (Roles.ROLE_ADMIN.getRole().equals(roleService.getRoleCurrentUser())) {
            return "redirect:/admin/signupform";
        }
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        map.put("userAccounts", userFacade.getUserAccountList(userDetails.getUsername()));
        return "user/accounts";
    }

}
