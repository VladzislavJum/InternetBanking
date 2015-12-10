package by.jum.internetbanking.converter.history;

import by.jum.internetbanking.entity.PaymentHistory;
import by.jum.internetbanking.form.money.PaymentForServicesForm;
import by.jum.internetbanking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Component
public class PaymentForServicesFormToHistoryConverter implements Converter<PaymentForServicesForm, PaymentHistory> {

    @Autowired
    private UserService userService;

    @Override
    public PaymentHistory convert(PaymentForServicesForm paymentForServicesForm) {
        PaymentHistory history = new PaymentHistory();
        history.setUser(userService.getUserByID(paymentForServicesForm.getUserID()));
        history.setObjectTo(paymentForServicesForm.getNameCorp());
        history.setNumberAccountFrom(paymentForServicesForm.getNumberAccountFrom());

        history.setDateTime(new Timestamp(new Date().getTime()));
        history.setAmountOfMoney(new BigDecimal(paymentForServicesForm.getAmountOfMoney()));
        return history;
    }
}
