package by.jum.internetbanking.controllers.user;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.facade.CorporationFacade;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.form.money.PaymentForServicesForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private CorporationFacade corporationFacade;

    @RequestMapping(value = "payment", method = RequestMethod.GET)
    public String pay(Model model, @ModelAttribute("currentUserID") long currentUserID) {
        List<BankAccountDTO> accountDTOList = userFacade.getUserAccountList(currentUserID);
        model.addAttribute("accountList", accountDTOList);
        return "user/paymentForServices";
    }

    @RequestMapping(value = "payment/internet/{name}", method = RequestMethod.GET)
    public String internet(Model model, @ModelAttribute("currentUserID") long currentUserID, @PathVariable("name") String name) {
        PaymentForServicesForm servicesForm = new PaymentForServicesForm();
        servicesForm.setNameCorp(name);
        List<BankAccountDTO> accountDTOList = userFacade.getUserAccountList(currentUserID);
        model.addAttribute("accountList", accountDTOList);
        model.addAttribute("name", name);
        model.addAttribute("servicesForm", servicesForm);

        return "user/internetPayment";
    }

    @RequestMapping(value = "payment/internet/pay", method = RequestMethod.POST)
    public String internetPay(@ModelAttribute("servicesForm") PaymentForServicesForm servicesForm,
                              final BindingResult result, Model model, @ModelAttribute("currentUserID") long currentUserID) {

        corporationFacade.transferMoney(servicesForm);

        return "user/internetPayment";
    }

}
