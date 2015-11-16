package by.jum.internetbanking.controllers.user;

import by.jum.internetbanking.dto.PaymentHistoryDTO;
import by.jum.internetbanking.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("currentUserID")
@RequestMapping("/user")
public class PaymentHistoryController {

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String showHistory(Model model, @ModelAttribute("currentUserID") long currentUserID) {
        List<PaymentHistoryDTO> historyDTOList = userFacade.getHistoryUserList(currentUserID);
        model.addAttribute("historyList", historyDTOList);

        return "user/paymentHistory";
    }
}
