package by.jum.internetbanking.controllers.admin;

import by.jum.internetbanking.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class LockingController {

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = "users/{id}/lockorunlock", method = RequestMethod.GET)
    public String lockOrUnlockUser(@PathVariable("id") long id) {
        userFacade.lockOrUnlockUser(id);
        return "redirect:/admin/users";
    }

}
