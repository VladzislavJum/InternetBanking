package by.jum.internetbanking.controllers.user;

import by.jum.internetbanking.dto.PaymentHistoryDTO;
import by.jum.internetbanking.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("user")
public class PaymentHistoryController {

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String showHistory(Model model) {
        List<PaymentHistoryDTO> historyDTOList = userFacade.getHistoryUserList(userFacade.getIDCurrentUser());
        model.addAttribute("historyList", historyDTOList);

        return "user/paymentHistory";
    }
}
