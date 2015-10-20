package by.jum.internetbanking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainPageController {
    @RequestMapping(value = "/welcome", method = RequestMethod.POST)
    public String printWelcome() {
        return "welcome";
    }


    @RequestMapping(value = "/error", method = RequestMethod.POST)
    public String printError() {
        return "error";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String printUser() {
        return "user";
    }
}
