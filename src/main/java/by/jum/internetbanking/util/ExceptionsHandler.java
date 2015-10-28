package by.jum.internetbanking.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(HttpServletRequest httpServletRequest, Exception ex) {
        ModelAndView model = new ModelAndView("/error");
        model.addObject("url", httpServletRequest.getRequestURL());
        model.addObject("trace", ex);

        model.setViewName("errors/error");

        return model;
    }

    @RequestMapping(value = "/error403", method = RequestMethod.POST)
    public String printError() {
        return "403";
    }

}