package by.jum.internetbanking.controllers;

import by.jum.internetbanking.Role;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;


@Controller
public class AuthorizationController {

    private final Logger LOGGER = Logger.getLogger(getClass());

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(required = false) String error) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Iterator<GrantedAuthority> iterator = (Iterator<GrantedAuthority>) auth.getAuthorities().iterator();
        String role = iterator.next().getAuthority();
        if (Role.ROLE_ADMIN.getRole().equals(role)) {
            return new ModelAndView("redirect:/admin/signupform");
        } else if (Role.ROLE_USER.getRole().equals(role)) {
            return new ModelAndView("redirect:/user/accounts");
        }

        String message = "";
        if (error != null) {
            message = messageSource.getMessage("authorization.label.invalid", null, LocaleContextHolder.getLocale());
        }
            return new ModelAndView("login", "message", message);
        }
    }


