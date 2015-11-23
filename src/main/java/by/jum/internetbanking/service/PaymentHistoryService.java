package by.jum.internetbanking.service;

import by.jum.internetbanking.entity.PaymentHistory;

import java.util.List;

public interface PaymentHistoryService {
    void delete(PaymentHistory history);

    PaymentHistory getById(Long id);

    void save(PaymentHistory history);

    List<PaymentHistory> getPaymentHistoryByUserId(long userId);
}
