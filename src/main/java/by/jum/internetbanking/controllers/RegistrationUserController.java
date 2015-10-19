package by.jum.internetbanking.controllers;

import by.jum.internetbanking.dto.UserDTO;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.form.RegistrationUserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class RegistrationUserController {

    @Autowired
    UserFacade userFacade;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String printWelcome() {
        return "welcome";
    }


    @RequestMapping(value = "/signupgood", method = RequestMethod.POST)
    public String register(@ModelAttribute("userDTO")UserDTO userDTO) {
        userFacade.registerUser(userDTO);
        return "welcome";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String showRegistrationForm(Map<String, Object> map) {

        map.put("userForm", new UserDTO());
        //map.put("contactList", contactService.listContact());

        return "registerUser";
    }
}
