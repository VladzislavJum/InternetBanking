package by.jum.internetbanking.dao.impl;

import by.jum.internetbanking.dao.UserDAO;
import by.jum.internetbanking.enity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<User> getUsers() {
        return sessionFactory.getCurrentSession().createQuery("from by.jum.internetbanking.enity.User")
                .list();
    }

    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public void pay() {

    }

    public void lockCard() {

    }

    public void unlockCard() {

    }
}
