package by.jum.internetbanking.dao;

import by.jum.internetbanking.entity.PaymentHistory;
import by.jum.internetbanking.entity.Role;

public interface PaymentHistoryDAO {
    void delete(PaymentHistory history);

    PaymentHistory getById(Long id);

    void save(PaymentHistory history);
}
