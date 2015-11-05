package by.jum.internetbanking.controllers.admin;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.dto.UserDTO;
import by.jum.internetbanking.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ShowingController {

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showUsers(Model model) {
        List<UserDTO> userDTOList = userFacade.getUserList();
        Collections.reverse(userDTOList);
        model.addAttribute("userList", userDTOList);
        return "admin/showUsers";
    }


    @RequestMapping(value = "/users/{id}/accounts", method = RequestMethod.GET)
    public String showUserAccounts(@PathVariable("id") long id, Model model) {
        List<BankAccountDTO> accountDTOList = userFacade.getUserAccountList(id);
        model.addAttribute("accountList", accountDTOList);
        model.addAttribute("userID", id);
        return "admin/showAccounts";
    }
}
