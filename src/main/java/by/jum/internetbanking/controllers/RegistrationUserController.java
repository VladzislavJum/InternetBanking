package by.jum.internetbanking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class RegistrationUserController {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String printWelcome() {
        return "welcome";
    }
}
