package by.jum.internetbanking.facade;

import by.jum.internetbanking.entity.PaymentHistory;

public interface PaymentHistoryFacade {
    void deleteHistory(PaymentHistory history);

    PaymentHistory getHistoryById(Long id);

    void saveHistory(PaymentHistory history);
}
