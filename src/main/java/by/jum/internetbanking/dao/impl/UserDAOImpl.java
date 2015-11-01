package by.jum.internetbanking.dao.impl;

import by.jum.internetbanking.dao.UserDAO;
import by.jum.internetbanking.entity.BankAccount;
import by.jum.internetbanking.entity.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDAOImpl extends AbstractBaseDAO implements UserDAO {

    private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class);

    public List<User> getList() {
        return getSessionFactory().getCurrentSession().createQuery("from by.jum.internetbanking.entity.User").list();
    }

    public void delete(User user) {
        super.save(user);
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
        User user = (User)super.getByID(User.class, id);

        StringBuilder builder = new StringBuilder("User with id ");
        builder.append(id);
        builder.append(": ");
        builder.append(user);
        LOGGER.info(builder);

        return user;
    }

    @Override
     public User getByUserName(String login) {
        User user = (User) getSessionFactory().getCurrentSession().
                createQuery("from by.jum.internetbanking.entity.User u where u.login=:login").setParameter("login", login).uniqueResult();

        StringBuilder builder = new StringBuilder("User with login: ");
        builder.append(login);
        builder.append(" exist: ");
        builder.append(user != null);
        LOGGER.info(builder);

        return user;
    }

    @Override
    public List<BankAccount> getAccountUserList(String login) {
        return getByUserName(login).getBankAccountList();
    }
}