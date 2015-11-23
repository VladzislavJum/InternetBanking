package by.jum.internetbanking.dao.impl;

import by.jum.internetbanking.dao.PaymentHistoryDAO;
import by.jum.internetbanking.dao.UserDAO;
import by.jum.internetbanking.entity.PaymentHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentHistoryDAOImpl extends AbstractBaseDAO implements PaymentHistoryDAO {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void delete(PaymentHistory history) {
        super.delete(history);
    }

    @Override
    public PaymentHistory getById(Long id) {
        return null;
    }

    @Override
    public void save(PaymentHistory history) {
        super.save(history);
    }

    @Override
    public List<PaymentHistory> getPaymentHistoryByUserId(long userId) {
        return userDAO.getById(userId).getPaymentHistoryList();

    }
}
