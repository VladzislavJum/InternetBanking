package by.jum.internetbanking.controllers;

import by.jum.internetbanking.form.RegistrationUserForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/admin")
public class RegistrationUserController {

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String showRegistrationForm(Map<String, Object> map) {
        map.put("userForm", new RegistrationUserForm());
        return "registerUser";
    }

}
