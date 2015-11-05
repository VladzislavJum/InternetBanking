package by.jum.internetbanking.controllers;

import by.jum.internetbanking.Roles;
import by.jum.internetbanking.facade.RoleFacade;
import by.jum.internetbanking.facade.UserFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
public class AuthorizationController {

    private static final Logger LOGGER = Logger.getLogger(AuthorizationController.class);

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private RoleFacade roleFacade;

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView authorisationForm(@RequestParam(required = false) String error, HttpSession session) {
        String role = roleFacade.getRoleCurrentUser();
        if (Roles.ROLE_ADMIN.getRole().equals(role)) {
            session.setAttribute("currentUserID", userFacade.getIDCurrentUser());
            LOGGER.info("User with role " + role + " authorized");
            return new ModelAndView("redirect:/admin/users");
        } else if (Roles.ROLE_USER.getRole().equals(role)) {
            session.setAttribute("currentUserID", userFacade.getIDCurrentUser());
            LOGGER.info("User with role " + role + " authorized");
            return new ModelAndView("redirect:/user/accounts");
        }
        String message = "";
        if (error != null) {
            message = messageSource.getMessage("authorization.label.error.passlogin", null, LocaleContextHolder.getLocale());
            LOGGER.info(message);
        }
        return new ModelAndView("login", "message", message);
    }
}


