package by.jum.internetbanking.util;

import by.jum.internetbanking.controllers.AuthorizationController;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionsHandler {

    private static final Logger LOGGER = Logger.getLogger(AuthorizationController.class);

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(HttpServletRequest httpServletRequest, Exception ex) {
        ModelAndView modelAndView = new ModelAndView("errors/error");
        modelAndView.addObject("url", httpServletRequest.getRequestURL());
        modelAndView.addObject("trace", ex);
        StackTraceElement[] stackTraceElements = ex.getStackTrace();
        LOGGER.error("Exception!!!");
        for (StackTraceElement trace : stackTraceElements) {
            LOGGER.error(trace);
        }
        return modelAndView;
    }
}