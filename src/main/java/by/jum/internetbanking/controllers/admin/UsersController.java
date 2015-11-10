package by.jum.internetbanking.controllers.admin;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.dto.UserDTO;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.form.history.PaymentHistoryForm;
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
public class UsersController {

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showUsers(Model model) {
        List<UserDTO> userDTOList = userFacade.getUserList();
        model.addAttribute("userList", userDTOList);
        return "admin/showUsers";
    }

    @RequestMapping(value = "/users/{id}/accounts", method = RequestMethod.GET)
    public String showUserAccounts(@PathVariable("id") long id, Model model) {
        List<BankAccountDTO> accountDTOList = userFacade.getUserAccountList(id);
        model.addAttribute("accountList", accountDTOList);
        model.addAttribute("userID", id);
        model.addAttribute("historyForm", new PaymentHistoryForm());
        return "admin/showAccounts";
    }

    @RequestMapping(value = "users/{id}/delete", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") long id) {
        userFacade.deleteUserByID(id);
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "users/{id}/lockorunlock", method = RequestMethod.GET)
    public String lockOrUnlockUser(@PathVariable("id") long id) {
        userFacade.lockOrUnlockUser(id);
        return "redirect:/admin/users";
    }
}
