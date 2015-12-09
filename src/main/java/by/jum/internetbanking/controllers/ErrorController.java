package by.jum.internetbanking.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

    private static final Logger LOGGER = Logger.getLogger(ErrorController.class);

    @RequestMapping("/403error")
    public String error403() {
        LOGGER.warn("HTTP Status 403 - Access is denied!");
        return "errors/403";
    }

    @RequestMapping("/404error")
    public String error404() {
        LOGGER.warn("HTTP Status 403 - page not found!");
        return "errors/404";
    }

    @RequestMapping("/500error")
    public String error500() {
        LOGGER.warn("HTTP Status 500");
        return "errors/500";
    }

}
