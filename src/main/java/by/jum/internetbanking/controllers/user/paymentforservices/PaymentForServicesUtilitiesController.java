package by.jum.internetbanking.controllers.user.paymentforservices;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.facade.CorporationFacade;
import by.jum.internetbanking.facade.PaymentHistoryFacade;
import by.jum.internetbanking.facade.UserFacade;
import by.jum.internetbanking.form.money.PaymentForServicesForm;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("user")
public class PaymentForServicesUtilitiesController {

    private static final Logger LOGGER = Logger.getLogger(PaymentForServicesUtilitiesController.class);

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private Validator paymentForServicesUtilitiesValidator;

    @Autowired
    @Qualifier("corporationUtilitiesFacade")
    private CorporationFacade corporationFacade;

    @Autowired
    private PaymentHistoryFacade historyFacade;

    @RequestMapping(value = "/payment/service/utilities/{name}", method = RequestMethod.GET)
    public String showUtilities(Model model, @PathVariable("name") String name,
                                @RequestParam(required = false) String success) {
        if (success != null) {
            String message = messageSource.getMessage("moneytrans.label.resultsuccess", null, LocaleContextHolder.getLocale());
            model.addAttribute("result", message);
        }

        if (corporationFacade.getByName(name) == null) {
            return "redirect:/user/payment";
        }
        PaymentForServicesForm servicesForm = new PaymentForServicesForm();
        servicesForm.setNameCorp(name);
        List<BankAccountDTO> accountDTOList = userFacade.getUserAccountList(userFacade.getIDCurrentUser());
        model.addAttribute("accountList", accountDTOList);
        model.addAttribute("name", name);
        model.addAttribute("servicesForm", servicesForm);
        return "user/serviceUtilitiesPayment";
    }

    @RequestMapping(value = "/payment/service/utilities/{name}/pay", method = {RequestMethod.POST, RequestMethod.GET})
    public String utilitiesPay(@ModelAttribute("servicesForm") PaymentForServicesForm servicesForm,
                               final BindingResult result, Model model, @PathVariable("name") String nameServ) {
        if (StringUtils.isEmpty(servicesForm.getNameCorp())) {
            return "redirect:/user/payment/service/utilities/" + nameServ;
        }
        long currentUserID = userFacade.getIDCurrentUser();
        paymentForServicesUtilitiesValidator.validate(servicesForm, result);
        if (result.hasErrors()) {
            LOGGER.info("Validation paymentForServices error");
            String message = messageSource.getMessage("moneytrans.label.resultunsuccess", null, LocaleContextHolder.getLocale());
            model.addAttribute("result", message);
            List<BankAccountDTO> accountDTOList = userFacade.getUserAccountList(currentUserID);
            model.addAttribute("name", servicesForm.getNameCorp());
            model.addAttribute("accountList", accountDTOList);
            model.addAttribute("servicesForm", servicesForm);
            return "user/serviceUtilitiesPayment";
        }
        servicesForm.setUserID(currentUserID);
        corporationFacade.transferMoney(servicesForm);
        historyFacade.savePaymentHistory(servicesForm);
        return messageSource.getMessage("controller.label.redirectpayutilities", new Object[]{servicesForm.getNameCorp()}, Locale.ENGLISH);
    }
}
