package by.jum.internetbanking.facade.impl;

import by.jum.internetbanking.entity.PaymentHistory;
import by.jum.internetbanking.facade.PaymentHistoryFacade;
import by.jum.internetbanking.service.PaymentHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentHistoryFacadeImpl implements PaymentHistoryFacade {

    @Autowired
    private PaymentHistoryService historyService;

    @Override
    public void deleteHistory(PaymentHistory history) {
        historyService.delete(history);
    }

    @Override
    public PaymentHistory getHistoryById(Long id) {
        return historyService.getById(id);
    }

    @Override
    public void saveHistory(PaymentHistory history) {
        historyService.save(history);
    }
}
