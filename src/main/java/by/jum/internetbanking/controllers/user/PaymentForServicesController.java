package by.jum.internetbanking.controllers.user;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.form.money.MoneyTransactionForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequestMapping("/user")
@SessionAttributes("currentUserID")
public class PaymentForServicesController {

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = "payment", method = RequestMethod.GET)
    public String pay(Model model, @ModelAttribute("currentUserID") long currentUserID) {
        List<BankAccountDTO> accountDTOList = userFacade.getUserAccountList(currentUserID);
        model.addAttribute("accountList", accountDTOList);
        return "user/paymentForServices";
    }

    @RequestMapping(value = "payment/internet", method = RequestMethod.GET)
    public String internetPay(Model model, @ModelAttribute("currentUserID") long currentUserID) {
        List<BankAccountDTO> accountDTOList = userFacade.getUserAccountList(currentUserID);
        model.addAttribute("accountList", accountDTOList);
        model.addAttribute("transactionForm", new MoneyTransactionForm());
        return "user/internetPayment";
    }
}
