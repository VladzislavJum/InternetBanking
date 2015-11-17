package by.jum.internetbanking.facade.converter.history;

import by.jum.internetbanking.entity.PaymentHistory;
import by.jum.internetbanking.form.money.MoneyTransactionForm;
import by.jum.internetbanking.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Component
public class TransactionFormToHistoryConverter implements Converter<MoneyTransactionForm, PaymentHistory> {

    private static final Logger LOGGER = Logger.getLogger(TransactionFormToHistoryConverter.class);

    @Autowired
    private UserService userService;

    @Override
    public PaymentHistory convert(MoneyTransactionForm transactionForm) {
        PaymentHistory history = new PaymentHistory();
        history.setUser(userService.getUserByID(transactionForm.getUserID()));
        history.setAmountOfMoney(new BigDecimal(transactionForm.getAmountOfTransferredMoney()));
        history.setNumberAccountFrom(transactionForm.getNumberAccountFrom());
        history.setNumberAccountTo(transactionForm.getNumberAccountTo());

        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm");
        Date date = new Date();

        history.setDataTime(dateFormat.format(date));

        return history;
    }
}
