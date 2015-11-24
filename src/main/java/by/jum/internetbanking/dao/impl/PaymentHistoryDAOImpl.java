package by.jum.internetbanking.dao.impl;

import by.jum.internetbanking.dao.PaymentHistoryDAO;
import by.jum.internetbanking.dao.UserDAO;
import by.jum.internetbanking.entity.PaymentHistory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;

@Repository
public class PaymentHistoryDAOImpl extends AbstractBaseDAO implements PaymentHistoryDAO {

    private static final Logger LOGGER = Logger.getLogger(PaymentHistoryDAOImpl.class);

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private MessageSource messageSource;

    @Override
    public void delete(PaymentHistory history) {
        super.delete(history);
        LOGGER.info("DAO: history deleted");
    }

    @Override
    public PaymentHistory getById(Long id) {
        PaymentHistory history = (PaymentHistory) super.getByID(PaymentHistory.class, id);
        LOGGER.info(messageSource.getMessage("print.gethistorybyid", new Object[]{id, history}, Locale.ENGLISH));
        return history;
    }

    @Override
    public void save(PaymentHistory history) {
        super.save(history);
        LOGGER.info("DAO: history saved");
    }

    @Override
    public List<PaymentHistory> getPaymentHistoryByUserId(long userId) {
        return userDAO.getById(userId).getPaymentHistoryList();
    }

    @Override
    public void update(PaymentHistory history) {
        super.update(history);
        LOGGER.info("DAO: history updated");
    }

}
