package by.jum.internetbanking.service;

import by.jum.internetbanking.entity.PaymentHistory;
import by.jum.internetbanking.entity.Role;

public interface PaymentHistoryService {
    void delete(PaymentHistory history);

    PaymentHistory getById(Long id);

    void save(PaymentHistory history);
}
