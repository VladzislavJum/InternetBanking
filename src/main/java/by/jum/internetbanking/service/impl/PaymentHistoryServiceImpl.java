package by.jum.internetbanking.service.impl;

import by.jum.internetbanking.dao.PaymentHistoryDAO;
import by.jum.internetbanking.entity.PaymentHistory;
import by.jum.internetbanking.service.PaymentHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaymentHistoryServiceImpl implements PaymentHistoryService {

    @Autowired
    private PaymentHistoryDAO historyDAO;

    @Override
    @Transactional
    public void delete(PaymentHistory history) {
        historyDAO.delete(history);
    }

    @Override
    @Transactional
    public PaymentHistory getById(Long id) {
        return historyDAO.getById(id);
    }

    @Override
    @Transactional
    public void save(PaymentHistory history) {
        historyDAO.save(history);
    }

    @Override
    public List<PaymentHistory> getPaymentHistoryByUserId(long userId) {
        return historyDAO.getPaymentHistoryByUserId(userId);
    }
}
