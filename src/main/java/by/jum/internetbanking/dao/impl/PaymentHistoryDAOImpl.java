package by.jum.internetbanking.dao.impl;

import by.jum.internetbanking.dao.PaymentHistoryDAO;
import by.jum.internetbanking.entity.PaymentHistory;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentHistoryDAOImpl extends AbstractBaseDAO implements PaymentHistoryDAO {

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
}
