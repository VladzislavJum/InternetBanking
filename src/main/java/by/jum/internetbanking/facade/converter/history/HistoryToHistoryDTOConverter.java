package by.jum.internetbanking.facade.converter.history;

import by.jum.internetbanking.dto.PaymentHistoryDTO;
import by.jum.internetbanking.entity.PaymentHistory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HistoryToHistoryDTOConverter implements Converter<PaymentHistory, PaymentHistoryDTO>{
    @Override
    public PaymentHistoryDTO convert(PaymentHistory history) {
        PaymentHistoryDTO historyDTO = new PaymentHistoryDTO();
        historyDTO.setUserID(history.getUser().getUserID());
        historyDTO.setAmountOfMoney(history.getAmountOfMoney());
        historyDTO.setAccountNumberFrom(history.getNumberAccountFrom());
        historyDTO.setAccountNumberTo(history.getNumberAccountTo());
        historyDTO.setPaymentHistoryID(history.getHistoryID());
        historyDTO.setDataTime(history.getDataTime());
        return historyDTO;
    }
}
