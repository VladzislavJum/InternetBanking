package by.jum.internetbanking.controllers.admin;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.dto.UserDTO;
import by.jum.internetbanking.facade.BankAccountFacade;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.form.user.SearchForm;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "users/search", method = {RequestMethod.POST, RequestMethod.GET})
    public String searchUser(@ModelAttribute("searchUserForm") SearchForm searchForm, Model model) {
        LOGGER.info("Search user" + searchForm.getSearchStr());
        UserDTO userDTO = userFacade.getUserByUserName(searchForm.getSearchStr());
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

    @RequestMapping(value = "account/search", method = {RequestMethod.POST, RequestMethod.GET})
    public String searchAccount(@ModelAttribute("searchAccountForm") SearchForm searchForm, Model model) {
        LOGGER.info("Search account " + searchForm.getSearchStr());
        BankAccountDTO accountDTO = accountFacade.getAccountByNumber(searchForm.getSearchStr());
        if (accountDTO != null) {
            List<BankAccountDTO> bankAccountDTOList = new ArrayList<>();
            bankAccountDTOList.add(accountDTO);
            model.addAttribute("accountList", bankAccountDTOList);
            model.addAttribute("userID", accountDTO.getUserID());
        } else {
            String message = messageSource.getMessage("searchaccount.label.error.accountnotexist", null, LocaleContextHolder.getLocale());
            model.addAttribute("notExist", message);
        }
        return "admin/showAccounts";
    }
}
