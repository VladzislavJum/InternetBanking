package by.jum.internetbanking.dao.impl;

import by.jum.internetbanking.dao.BankAccountDAO;
import by.jum.internetbanking.entity.BankAccount;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BankAccountDAOImpl extends AbstractBaseDAO implements BankAccountDAO {
    @Override
    public List<BankAccount> getList() {
        return getSessionFactory().getCurrentSession().createQuery("from by.jum.internetbanking.entity.BankAccount").list();
    }

    @Override
    public void save(BankAccount account) {
        super.save(account);
    }

    @Override
    public void update(BankAccount account) {
        super.update(account);
    }

    @Override
    public void delete(BankAccount account) {
        super.delete(account);
    }

    @Override
    public BankAccount getByID(Long id) {
        return (BankAccount) super.getByID(BankAccount.class, id);
    }

    @Override
    public boolean isExistNumber(Integer accountNumber){
        Object object = getSessionFactory().getCurrentSession().
                createQuery("from by.jum.internetbanking.entity.BankAccount b where b.accountNumber=:accountNumber").setParameter("accountNumber", accountNumber).uniqueResult();
        return object != null;
    }

}
