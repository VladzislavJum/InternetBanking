package by.jum.internetbanking.controllers.admin;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.dto.UserDTO;
import by.jum.internetbanking.facade.BankAccountFacade;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.util.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class SearchingController {

    private static final Logger LOGGER = Logger.getLogger(SearchingController.class);

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private BankAccountFacade accountFacade;

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String searchUser(Model model, @PathVariable("id") long userID) {
        LOGGER.info("Search user");
        UserDTO userDTO = userFacade.getUserByID(userID);
        if (userDTO != null) {
            List<UserDTO> userDTOList = new ArrayList<>();
            userDTOList.add(userDTO);
            model.addAttribute("userList", userDTOList);
        } else {
            String message = messageSource.getMessage("searchuser.label.error.usernotexist", null, LocaleContextHolder.getLocale());
            model.addAttribute("message", message);
        }
        return "admin/showUsers";
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    public String searchAccount(Model model, @PathVariable("id") long accountID) {
        LOGGER.info("Search Acc");
        BankAccountDTO accountDTO = accountFacade.getAccountByID(accountID);
        UserDTO userDTO = userFacade.getUserByID(accountDTO.getUserID());
        if (accountDTO != null) {
            List<BankAccountDTO> bankAccountDTOList = new ArrayList<>();
            bankAccountDTOList.add(accountDTO);
            model.addAttribute("accountList", bankAccountDTOList);
            model.addAttribute("user", userDTO);
        } else {
            String message = messageSource.getMessage("searchaccount.label.error.accountnotexist", null, LocaleContextHolder.getLocale());
            model.addAttribute("notExist", message);
            model.addAttribute("user", userDTO);
        }
        return "admin/showAccounts";
    }

    @JsonView(Views.Account.class)
    @RequestMapping(value = "/account/searchAcc", method = RequestMethod.POST)
    public
    @ResponseBody
    List<BankAccountDTO> getAccountsByNumbers(@RequestBody BankAccountDTO accountDTO) {
        String number = accountDTO.getAccountNumber();
        if (StringUtils.isEmpty(number)) {
            LOGGER.info("Not value");
            return new ArrayList<>();
        } else {
            LOGGER.info("Search Acc Value " + number);
            List<BankAccountDTO> accountDTOList = accountFacade.findListAccountsByNumber(number);
            return accountDTOList;
        }
    }

    @JsonView(Views.User.class)
    @RequestMapping(value = "/users/searchUsers", method = RequestMethod.POST)
    public
    @ResponseBody
    List<UserDTO> getUsersByLogin(@RequestBody UserDTO userDTO) {
        String login = userDTO.getLogin();
        if (StringUtils.isEmpty(login)) {
            LOGGER.info("Not value");
            return new ArrayList<>();
        } else {
            LOGGER.info("Search User Value " + login);
            List<UserDTO> userDTOList = userFacade.findListUsersByLogin(login);
            return userDTOList;
        }
    }
}
