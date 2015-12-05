package by.jum.internetbanking.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccessController {

    private static final Logger LOGGER = Logger.getLogger(AccessController.class);

    @RequestMapping("/403error")
    public String error403() {
        LOGGER.warn("HTTP Status 403 - Access is denied!");
        return "errors/403";
    }
}
