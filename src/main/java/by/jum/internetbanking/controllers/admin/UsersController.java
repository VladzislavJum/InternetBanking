package by.jum.internetbanking.controllers.admin;

import by.jum.internetbanking.dto.UserDTO;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.util.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("admin")
public class UsersController {

    private static final Logger LOGGER = Logger.getLogger(UsersController.class);

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showUsers(Model model) {
        List<UserDTO> userDTOList = userFacade.getUserList();
        model.addAttribute("userList", userDTOList);
        return "admin/showUsers";
    }

    @RequestMapping(value = "/users/lockorunlock", method = RequestMethod.POST)
    public
    @ResponseBody
    boolean lockOrUnlockUser(@RequestBody long userID) {
        LOGGER.info(userFacade.getIDCurrentUser());
        if (userFacade.getIDCurrentUser() != userID) {
            userFacade.lockOrUnlockUser(userID);
            LOGGER.info("LockOrUnlock user id: " + userID);
            return true;
        }
        LOGGER.info("Not LockOrUnlock user id: " + userID);
        return false;
    }

    @RequestMapping(value = "/users/deleteuser", method = RequestMethod.POST)
    @JsonView(Views.Account.class)
    public
    @ResponseBody
    boolean deleteAcc(@RequestBody long userID) {
        if (userFacade.getIDCurrentUser() != userID) {
            userFacade.deleteUserByID(userID);
            LOGGER.info("Delete user id: " + userID);
            return true;
        }
        LOGGER.info("Not Deleting user id: " + userID);
        return false;
    }
}
