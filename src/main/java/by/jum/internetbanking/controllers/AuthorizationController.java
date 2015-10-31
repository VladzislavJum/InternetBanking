package by.jum.internetbanking.controllers;

import by.jum.internetbanking.Roles;
import by.jum.internetbanking.service.RoleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AuthorizationController {

    private static final Logger LOGGER = Logger.getLogger(AuthorizationController.class);

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView authorisationForm(@RequestParam(required = false) String error) {
        String role = roleService.getRoleCurrentUser();
        if (Roles.ROLE_ADMIN.getRole().equals(role)) {
            return new ModelAndView("redirect:/admin/signupform");
        } else if (Roles.ROLE_USER.getRole().equals(role)) {
            return new ModelAndView("redirect:/user/accounts");
        }
        String message = "";
        if (error != null) {
            message = messageSource.getMessage("authorization.label.error.passlogin", null, LocaleContextHolder.getLocale());
        }
        return new ModelAndView("login", "message", message);
    }
}


