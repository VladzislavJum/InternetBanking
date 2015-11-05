package by.jum.internetbanking.util;

import by.jum.internetbanking.controllers.AuthorizationController;
import org.apache.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionsHandler {

    private static final Logger LOGGER = Logger.getLogger(AuthorizationController.class);

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(HttpServletRequest httpServletRequest, Exception ex) {
        ModelAndView model = new ModelAndView("/error");
        model.addObject("url", httpServletRequest.getRequestURL());
        model.addObject("trace", ex);
        model.setViewName("errors/error");

        LOGGER.error("Exception!!!");
        ex.printStackTrace();

        return model;
    }
}