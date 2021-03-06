package by.jum.internetbanking.controllers.user;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.facade.UserFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class);

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public String showUserAccounts(Model model) {
        LOGGER.info("Show userAccounts");
        List<BankAccountDTO> accountDTOList = userFacade.getUserAccountList(userFacade.getIDCurrentUser());
        model.addAttribute("accountList", accountDTOList);
        return "user/showUserAccounts";
    }

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public String pay() {
        return "user/paymentForServices";
    }
}
