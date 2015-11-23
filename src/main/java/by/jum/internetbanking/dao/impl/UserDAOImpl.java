package by.jum.internetbanking.dao.impl;

import by.jum.internetbanking.dao.UserDAO;
import by.jum.internetbanking.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;


@Repository
public class UserDAOImpl extends AbstractBaseDAO implements UserDAO {

    private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class);

    private static final long USER_ROLE_ID = 1L;

    private static final String GET_USERS_WITH_USER_ROLE_QUERY = "from by.jum.internetbanking.entity.User u where u.role = " + USER_ROLE_ID;
    private static final String GET_USER_BY_USERNAME_QUERY = "from by.jum.internetbanking.entity.User u where u.login = :login";

    private static final String IS_EXIST_WITH_PASSPORT = "from by.jum.internetbanking.entity.User u where u.passportNumber = :passportNumber";

    @Autowired
    private MessageSource messageSource;

    public List<User> getList() {
        LOGGER.info("DAO: Get UserList");
        Query query = getSessionFactory().getCurrentSession().createQuery(GET_USERS_WITH_USER_ROLE_QUERY);
        return query.list();
    }

    public void delete(User user) {
        super.delete(user);
        LOGGER.info("DAO: User deleted: Login " + user.getLogin());

    }

    public void update(User user) {
        super.update(user);
    }

    public void save(User user) {
        super.save(user);
        LOGGER.info("DAO: User created: Login " + user.getLogin());

    }

    public User getById(Long id) {
        User user = (User) super.getByID(User.class, id);
        LOGGER.info(messageSource.getMessage("print.getuserbyid", new Object[]{id, user}, Locale.ENGLISH));
        return user;
    }

    @Override
    public User getByUserName(String login) {
        User user = (User) getSessionFactory().getCurrentSession().
                createQuery(GET_USER_BY_USERNAME_QUERY).
                setParameter("login", login).uniqueResult();
        LOGGER.info(messageSource.getMessage("print.getbyusername", new Object[]{login, user != null}, Locale.ENGLISH));
        return user;
    }

    @Override
    public void deleteByID(long id) {
        User user = new User();
        user.setUserID(id);
        delete(getSessionFactory().getCurrentSession().merge(user));
        LOGGER.info("DAO: User Deleted: id " + id);
    }

    public boolean isExistUserWithPassportNumber(String passportNumber) {
        Object object = getSessionFactory().getCurrentSession().
                createQuery(IS_EXIST_WITH_PASSPORT).
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
        LOGGER.info("DAO: User is unlocked: " + user.isUnlocked());
    }
}