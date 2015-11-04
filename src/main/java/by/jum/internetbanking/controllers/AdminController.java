package by.jum.internetbanking.controllers;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.dto.UserDTO;
import by.jum.internetbanking.facade.BankAccountFacade;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.form.account.CreateBankAccountForm;
import by.jum.internetbanking.form.user.RegistrationUserForm;
import by.jum.internetbanking.form.user.SearchForm;
import by.jum.internetbanking.form.validator.CreateBankAccountFormValidator;
import by.jum.internetbanking.form.validator.RegistrationUserFormValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final Logger LOGGER = Logger.getLogger(AuthorizationController.class);

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private BankAccountFacade accountFacade;

    @Autowired
    private CreateBankAccountFormValidator accountFormValidator;

    @Autowired
    private RegistrationUserFormValidator userFormValidator;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/signupform", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("userForm", new RegistrationUserForm());
        return "/admin/createUser";
    }

    @RequestMapping(value = "/createaccountform", method = RequestMethod.GET)
    public String showCreatingAccountForm(Model model) {
        model.addAttribute("accountForm", new CreateBankAccountForm());
        return "admin/createAccount";
    }

    @RequestMapping(value = "/register", method = {RequestMethod.POST, RequestMethod.GET})
    public String registerUser(@ModelAttribute("userForm") RegistrationUserForm registrationUserForm,
                               final BindingResult result) {
        userFormValidator.validate(registrationUserForm, result);
        if (result.hasErrors()) {
            LOGGER.info("Validation registration error");
            return "admin/createUser";
        }
        userFacade.registerUser(registrationUserForm);
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/createaccount", method = {RequestMethod.POST, RequestMethod.GET})
    public String createAccount(@ModelAttribute("accountForm") CreateBankAccountForm accountForm,
                                final BindingResult result) {
        accountFormValidator.validate(accountForm, result);
        if (result.hasErrors()) {
            LOGGER.info("Validation createAccount error");
            return "admin/createAccount";
        }
        accountFacade.createAccount(accountForm);
        return "admin/createdSuccess";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showUsers(Model model) {
        List<UserDTO> userDTOList = userFacade.getUserList();
        Collections.reverse(userDTOList);
        model.addAttribute("userList", userDTOList);
        return "admin/showUsers";
    }

    @RequestMapping(value = "users/{id}/delete", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") long id) {
        userFacade.deleteUserByID(id);
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "users/search", method = RequestMethod.POST)
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

    @RequestMapping(value = "account/search", method = RequestMethod.POST)
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


    @RequestMapping(value = "/users/{id}/accounts", method = RequestMethod.GET)
    public String showUserAccounts(@PathVariable("id") long id, Model model) {
        List<BankAccountDTO> accountDTOList = userFacade.getUserAccountList(id);
        model.addAttribute("accountList", accountDTOList);
        model.addAttribute("userID", id);
        return "admin/showAccounts";
    }

    @RequestMapping(value = "/users/{id}/accounts/{acoountid}/delete", method = RequestMethod.GET)
    public String deleteAccount(@PathVariable("acoountid") long acoountid, @PathVariable("id") long id) {
        accountFacade.deleteAccountByID(acoountid);
        return messageSource.getMessage("controller.label.redirectshowusers", new Object[]{id}, Locale.ENGLISH);
    }

}
