package by.jum.internetbanking.facade.impl;

import by.jum.internetbanking.dto.PaymentHistoryDTO;
import by.jum.internetbanking.entity.PaymentHistory;
import by.jum.internetbanking.facade.PaymentHistoryFacade;
import by.jum.internetbanking.form.money.MoneyTransactionForm;
import by.jum.internetbanking.service.PaymentHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component
public class PaymentHistoryFacadeImpl implements PaymentHistoryFacade {

    @Autowired
    private PaymentHistoryService historyService;

    @Autowired
    private ConversionService conversionService;

    @Override
    public PaymentHistoryDTO getHistoryById(Long id) {
        PaymentHistory history = historyService.getById(id);
        return conversionService.convert(history, PaymentHistoryDTO.class);
    }

    @Override
    public void saveHistory(MoneyTransactionForm transactionForm) {
        historyService.save(conversionService.convert(transactionForm, PaymentHistory.class));
    }
}
