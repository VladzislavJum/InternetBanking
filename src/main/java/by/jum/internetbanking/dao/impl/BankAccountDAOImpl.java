package by.jum.internetbanking.dao.impl;

import by.jum.internetbanking.dao.BankAccountDAO;
import by.jum.internetbanking.dao.UserDAO;
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

    private static final String GET_ACCOUNT_BY_NUMBER_QUERY = "from by.jum.internetbanking.entity.BankAccount b where b.accountNumber=:accountNumber";
    private static final String GET_ALL_ACCOUNTS_QUERY = "from by.jum.internetbanking.entity.BankAccount";

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<BankAccount> getList() {
        Query query = getSessionFactory().getCurrentSession().createQuery(GET_ALL_ACCOUNTS_QUERY);
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
        BankAccount account = new BankAccount();
        account.setBankAccountID(id);
        delete(getSessionFactory().getCurrentSession().merge(account));
        LOGGER.info("DAO: Account Deleted: id " + id);
    }

    @Override
    public BankAccount getByID(Long id) {
        BankAccount account = (BankAccount) super.getByID(BankAccount.class, id);
        LOGGER.info(messageSource.getMessage("print.getaccountbyid", new Object[]{id, account}, Locale.ENGLISH));
        return account;
    }

    @Override
    public BankAccount getByNumber(String number) {
        BankAccount account = (BankAccount) getSessionFactory().getCurrentSession().
                createQuery(GET_ACCOUNT_BY_NUMBER_QUERY).
                setParameter("accountNumber", number).uniqueResult();
        LOGGER.info(messageSource.getMessage("print.getaccountbynumber", new Object[]{number, account}, Locale.ENGLISH));

        return account;
    }

    @Override
    public List<BankAccount> getAccountsByUserId(long userID) {
        return userDAO.getById(userID).getBankAccountList();
    }
}
