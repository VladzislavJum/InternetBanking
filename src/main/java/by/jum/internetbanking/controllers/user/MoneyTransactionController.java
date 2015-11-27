package by.jum.internetbanking.controllers.user;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.facade.BankAccountFacade;
import by.jum.internetbanking.facade.PaymentHistoryFacade;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.form.money.MoneyTransactionForm;
import by.jum.internetbanking.form.validator.MoneyTransactionValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequestMapping("/user")
public class MoneyTransactionController {

    private static final Logger LOGGER = Logger.getLogger(MoneyTransactionController.class);

    @Autowired
    private MoneyTransactionValidator moneyTransactionValidator;

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private BankAccountFacade accountFacade;

    @Autowired
    private PaymentHistoryFacade historyFacade;

    @RequestMapping(value = "/transaction", method = RequestMethod.GET)
    public String selectAccount(Model model) {
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
            List<BankAccountDTO> accountDTOList = userFacade.getUserAccountList(currentUserID);
            model.addAttribute("accountList", accountDTOList);
            model.addAttribute("transactionForm", transactionForm);
            return "user/moneyTransaction";
        }

        transactionForm.setUserID(currentUserID);
        accountFacade.transferMoney(transactionForm);
        historyFacade.saveTransactionHistory(transactionForm);

        return "redirect:/user/accounts";
    }
}
