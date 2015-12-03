package by.jum.internetbanking.facade.converter.history;

import by.jum.internetbanking.entity.PaymentHistory;
import by.jum.internetbanking.form.money.MoneyTransactionForm;
import by.jum.internetbanking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Component
public class TransactionFormToHistoryConverter implements Converter<MoneyTransactionForm, PaymentHistory> {

    @Autowired
    private UserService userService;

    @Override
    public PaymentHistory convert(MoneyTransactionForm transactionForm) {
        PaymentHistory history = new PaymentHistory();
        history.setUser(userService.getUserByID(transactionForm.getUserID()));
        history.setAmountOfMoney(new BigDecimal(transactionForm.getAmountOfTransferredMoney()));
        history.setNumberAccountFrom(transactionForm.getNumberAccountFrom());
        history.setObjectTo(transactionForm.getObjectTo());
        history.setDateTime(new Timestamp(new Date().getTime()));
        return history;
    }
}
