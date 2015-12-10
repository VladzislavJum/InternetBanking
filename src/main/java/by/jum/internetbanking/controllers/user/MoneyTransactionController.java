package by.jum.internetbanking.controllers.user;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.facade.BankAccountFacade;
import by.jum.internetbanking.facade.PaymentHistoryFacade;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.form.money.MoneyTransactionForm;
import by.jum.internetbanking.util.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("user")
public class MoneyTransactionController {

    private static final Logger LOGGER = Logger.getLogger(MoneyTransactionController.class);

    @Autowired
    private Validator moneyTransactionValidator;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private BankAccountFacade accountFacade;

    @Autowired
    private PaymentHistoryFacade historyFacade;

    @RequestMapping(value = "/transaction", method = RequestMethod.GET)
    public String selectAccount(Model model, @RequestParam(required = false) String success) {
        if (success != null) {
            String message = messageSource.getMessage("moneytrans.label.resultsuccess", null, LocaleContextHolder.getLocale());
            model.addAttribute("result", message);
        }
        List<BankAccountDTO> accountDTOList = userFacade.getUserAccountList(userFacade.getIDCurrentUser());
        model.addAttribute("accountList", accountDTOList);
        model.addAttribute("transactionForm", new MoneyTransactionForm());
        return "user/moneyTransaction";
    }

    @RequestMapping(value = "/transfer", method = {RequestMethod.POST, RequestMethod.GET})
    public String transact(@ModelAttribute("transactionForm") MoneyTransactionForm transactionForm,
                           final BindingResult result, Model model) {
        long currentUserID = userFacade.getIDCurrentUser();
        moneyTransactionValidator.validate(transactionForm, result);
        if (result.hasErrors()) {
            LOGGER.info("Validation moneyTransaction error");
            String message = messageSource.getMessage("moneytrans.label.resultunsuccess", null, LocaleContextHolder.getLocale());
            List<BankAccountDTO> accountDTOList = userFacade.getUserAccountList(currentUserID);
            model.addAttribute("accountList", accountDTOList);
            model.addAttribute("transactionForm", transactionForm);
            model.addAttribute("result", message);
            return "user/moneyTransaction";
        }
        transactionForm.setUserID(currentUserID);
        accountFacade.transferMoney(transactionForm);
        historyFacade.saveTransactionHistory(transactionForm);
        return "redirect:/user/transaction?success";
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
}
