package by.jum.internetbanking.facade.converter.history;

import by.jum.internetbanking.dto.PaymentHistoryDTO;
import by.jum.internetbanking.entity.PaymentHistory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Component
public class HistoryToHistoryDTOConverter implements Converter<PaymentHistory, PaymentHistoryDTO>{

    private static final String DATA_FORMAT = "dd.MM.yyyy HH:mm";

    @Override
    public PaymentHistoryDTO convert(PaymentHistory history) {
        PaymentHistoryDTO historyDTO = new PaymentHistoryDTO();
        historyDTO.setUserID(history.getUser().getUserID());
        historyDTO.setAmountOfMoney(history.getAmountOfMoney());
        historyDTO.setAccountNumberFrom(history.getNumberAccountFrom());
        historyDTO.setObjectTo(history.getObjectTo());
        historyDTO.setPaymentHistoryID(history.getHistoryID());
        DateFormat dateFormat = new SimpleDateFormat(DATA_FORMAT);

        historyDTO.setDateTime(dateFormat.format(history.getDateTime()));
        return historyDTO;
    }
}
