package by.jum.internetbanking.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class PaymentForServicesController {

    @RequestMapping(value = "payment", method = RequestMethod.GET)
    public String pay(Model model) {
        return "user/paymentForServices";
    }

}
