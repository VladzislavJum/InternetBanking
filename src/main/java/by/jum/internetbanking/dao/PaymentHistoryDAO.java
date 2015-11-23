package by.jum.internetbanking.dao;

import by.jum.internetbanking.entity.PaymentHistory;

import java.util.List;

public interface PaymentHistoryDAO {
    void delete(PaymentHistory history);

    PaymentHistory getById(Long id);

    void save(PaymentHistory history);

    List<PaymentHistory> getPaymentHistoryByUserId(long userId);
}
