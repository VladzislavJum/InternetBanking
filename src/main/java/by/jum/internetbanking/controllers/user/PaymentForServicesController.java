package by.jum.internetbanking.controllers.user;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.facade.CorporationFacade;
import by.jum.internetbanking.facade.PaymentHistoryFacade;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.form.money.PaymentForServicesForm;
import by.jum.internetbanking.form.validator.PaymentForServicesValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("user")
public class PaymentForServicesController {

    private static final Logger LOGGER = Logger.getLogger(PaymentForServicesController.class);

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private PaymentForServicesValidator paymentForServicesValidator;

    @Autowired
    private CorporationFacade corporationFacade;

    @Autowired
    private PaymentHistoryFacade historyFacade;

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public String pay(Model model) {
        List<BankAccountDTO> accountDTOList = userFacade.getUserAccountList(userFacade.getIDCurrentUser());
        model.addAttribute("accountList", accountDTOList);
        return "user/paymentForServices";
    }

    @RequestMapping(value = "/payment/service/{name}", method = RequestMethod.GET)
    public String internet(Model model, @PathVariable("name") String name) {
        PaymentForServicesForm servicesForm = new PaymentForServicesForm();
        servicesForm.setNameCorp(name);
        if (corporationFacade.getByName(name) == null) {
            return "redirect:/user/payment";
        }
        List<BankAccountDTO> accountDTOList = userFacade.getUserAccountList(userFacade.getIDCurrentUser());
        model.addAttribute("accountList", accountDTOList);
        model.addAttribute("name", name);
        model.addAttribute("servicesForm", servicesForm);
        return "user/servicePayment";
    }

    @RequestMapping(value = "/payment/service/pay", method = RequestMethod.POST)
    public String internetPay(@ModelAttribute("servicesForm") PaymentForServicesForm servicesForm,
                              final BindingResult result, Model model) {
        long currentUserID = userFacade.getIDCurrentUser();
        paymentForServicesValidator.validate(servicesForm, result);
        if (result.hasErrors()) {
            LOGGER.info("Validation paymentForServices error");
            List<BankAccountDTO> accountDTOList = userFacade.getUserAccountList(currentUserID);
            model.addAttribute("name", servicesForm.getNameCorp());
            model.addAttribute("accountList", accountDTOList);
            model.addAttribute("servicesForm", servicesForm);
            return "user/servicePayment";
        }
        servicesForm.setUserID(currentUserID);
        corporationFacade.transferMoney(servicesForm);
        historyFacade.savePaymentHistory(servicesForm);
        return "redirect:/user/payment";
    }

}
