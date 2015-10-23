package by.jum.internetbanking.dao.impl;

import by.jum.internetbanking.dao.UserDAO;
import by.jum.internetbanking.entity.Card;
import by.jum.internetbanking.entity.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDAOImpl extends AbstractBaseDAO implements UserDAO {

    private final Logger logger = Logger.getLogger(UserDAOImpl.class);


    public List<User> getList() {
        return getSessionFactory().getCurrentSession().createQuery("from by.jum.internetbanking.entity.User").list();
    }

    public void delete(User user) {
        super.save(user);
    }

    public void update(User user) {
        super.update(user);
    }

    public void save(User user) {
        super.save(user);
    }

    public User getById(Long id) {
        return getSessionFactory().getCurrentSession().get(User.class, id);
    }

    @Override
    public User getByUserName(String login) {
        List<User> userList = getSessionFactory().getCurrentSession().
                createQuery("from by.jum.internetbanking.entity.User u where u.login=:login").setParameter("login", login).list();
        if (userList.size() > 0) {
            logger.warn("user " + userList.get(0).getLogin());
            return userList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Card> getUserCardList(String login) {
        return getByUserName(login).getCardList();

    }
}