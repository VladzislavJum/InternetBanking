package by.jum.internetbanking.controllers;

import by.jum.internetbanking.dao.AbstractBaseDAO;
import by.jum.internetbanking.entity.User;
import by.jum.internetbanking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddUserController{

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    @ModelAttribute("user")
    public String addUser(@ModelAttribute("user") User user){
        //userService.addUser(user);
        return "registerUser";
    }
}
