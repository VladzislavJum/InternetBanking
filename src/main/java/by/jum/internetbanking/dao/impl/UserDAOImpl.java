package by.jum.internetbanking.dao.impl;

import by.jum.internetbanking.dao.UserDAO;
import by.jum.internetbanking.entity.BankAccount;
import by.jum.internetbanking.entity.Role;
import by.jum.internetbanking.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;


@Repository
public class UserDAOImpl extends AbstractBaseDAO implements UserDAO {

    private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class);
    private static final long ADMIN_ROLE_ID = 2L;

    @Autowired
    private MessageSource messageSource;

    public List<User> getList() {
        Role role = new Role();
        role.setRoleID(ADMIN_ROLE_ID);
        LOGGER.info("Get UserList");
        return getSessionFactory().getCurrentSession().createQuery("from by.jum.internetbanking.entity.User u " +
                "where u.role != :role").setParameter("role",  role).list();
    }

    public void delete(User user) {
        super.delete(user);
        LOGGER.info("User deleted: Login " + user.getLogin());

    }

    public void update(User user) {
        super.update(user);
    }

    public void save(User user) {
        super.save(user);
        LOGGER.info("User created: Login " + user.getLogin());

    }

    public User getById(Long id) {
        User user = (User) super.getByID(User.class, id);
        LOGGER.info(messageSource.getMessage("print.getuserbyid", new Object[]{id, user}, Locale.ENGLISH));
        return user;
    }

    @Override
    public User getByUserName(String login) {
        User user = (User) getSessionFactory().getCurrentSession().
                createQuery("from by.jum.internetbanking.entity.User u where u.login = :login").
                setParameter("login", login).uniqueResult();
        LOGGER.info(messageSource.getMessage("print.getbyusername", new Object[]{login, user != null}, Locale.ENGLISH));
        return user;
    }

    @Override
    public List<BankAccount> getAccountUserList(long id) {
        return getById(id).getBankAccountList();
    }

    @Override
    public void deleteByID(long id) {
        getSessionFactory().getCurrentSession().createQuery("delete from by.jum.internetbanking.entity.User u " +
                "where u.id = :id").setParameter("id", id).executeUpdate();
        LOGGER.info("User Deleted: id " + id);
    }

    public boolean isExistUserWithPassportNumber(String passportNumber) {
        Object object = getSessionFactory().getCurrentSession().
                createQuery("from by.jum.internetbanking.entity.User u where u.passportNumber = :passportNumber").
                setParameter("passportNumber", passportNumber).uniqueResult();
        boolean exist = object != null;
        LOGGER.info(messageSource.getMessage("print.isexistuserwithpassport", new Object[]{passportNumber, exist}, Locale.ENGLISH));
        return exist;
    }

    @Override
    public void lockOrUnlock(long id) {
        User user = getById(id);
        user.setIsEnabled(!user.isUnlocked());
        update(user);
        LOGGER.info("User is unlocked: " + user.isUnlocked());
    }
}