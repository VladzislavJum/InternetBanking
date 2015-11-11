package by.jum.internetbanking.dao.impl;

import by.jum.internetbanking.dao.BankAccountDAO;
import by.jum.internetbanking.entity.BankAccount;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;

@Repository
public class BankAccountDAOImpl extends AbstractBaseDAO implements BankAccountDAO {

    private static final Logger LOGGER = Logger.getLogger(BankAccountDAOImpl.class);

    @Autowired
    private MessageSource messageSource;

    @Override
    public List<BankAccount> getList() {
        Query query = getSessionFactory().getCurrentSession().createQuery("from by.jum.internetbanking.entity.BankAccount");
        return query.list();
    }

    @Override
    public void save(BankAccount account) {
        super.save(account);
        LOGGER.info("DAO: Account created: Number " + account.getAccountNumber());
    }

    @Override
    public void update(BankAccount account) {
        super.update(account);
    }

    @Override
    public void delete(BankAccount account) {
        super.delete(account);
        LOGGER.info("DAO: Account deleted: Number " + account.getAccountNumber());
    }

    @Override
    public void deleteByID(long id) {
        getSessionFactory().getCurrentSession().createQuery("delete from by.jum.internetbanking.entity.BankAccount b " +
                "where b.id = :id").setParameter("id", id).executeUpdate();
        LOGGER.info("DAO: Account Deleted: id " + id);
    }

    @Override
    public BankAccount getByID(Long id) {
        BankAccount account = (BankAccount) super.getByID(BankAccount.class, id);
        LOGGER.info(messageSource.getMessage("print.getaccountbyid", new Object[]{id, account.getAccountNumber()}, Locale.ENGLISH));
        return account;
    }

    @Override
    public BankAccount getByNumber(String number) {
        BankAccount account = (BankAccount) getSessionFactory().getCurrentSession().
                createQuery("from by.jum.internetbanking.entity.BankAccount b where b.accountNumber=:accountNumber").
                setParameter("accountNumber", number).uniqueResult();
        LOGGER.info(messageSource.getMessage("print.getaccountbynumber", new Object[]{number, account}, Locale.ENGLISH));

        return account;
    }
}
