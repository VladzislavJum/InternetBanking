package by.jum.internetbanking.dao.impl;

import by.jum.internetbanking.dao.BankAccountDAO;
import by.jum.internetbanking.entity.BankAccount;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BankAccountDAOImpl extends AbstractBaseDAO implements BankAccountDAO {

    private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class);

    @Override
    public List<BankAccount> getList() {
        return getSessionFactory().getCurrentSession().createQuery("from by.jum.internetbanking.entity.BankAccount").list();
    }

    @Override
    public void save(BankAccount account) {
        super.save(account);
        LOGGER.info("Account created: Number " + account.getAccountNumber());
    }

    @Override
    public void update(BankAccount account) {
        super.update(account);
    }

    @Override
    public void delete(BankAccount account) {
        super.delete(account);
        LOGGER.info("Account deleted: Number " + account.getAccountNumber());
    }

    @Override
    public BankAccount getByID(Long id) {
        BankAccount account = (BankAccount) super.getByID(BankAccount.class, id);

        StringBuilder builder = new StringBuilder("Account with id ");
        builder.append(id);
        builder.append(": Number ");
        builder.append(account.getAccountNumber());
        LOGGER.info(builder);

        return account;
    }

    @Override
    public boolean isExistNumber(Integer accountNumber){
        Object object = getSessionFactory().getCurrentSession().
                createQuery("from by.jum.internetbanking.entity.BankAccount b where b.accountNumber=:accountNumber").setParameter("accountNumber", accountNumber).uniqueResult();
        boolean exist = object != null;

        StringBuilder builder = new StringBuilder("Account number ");
        builder.append(accountNumber);
        builder.append(" exist: ");
        builder.append(exist);
        LOGGER.info(builder);

        return exist;
    }

}
