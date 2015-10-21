package by.jum.internetbanking.dao.impl;

import by.jum.internetbanking.dao.UserDAO;
import by.jum.internetbanking.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl extends AbstractBaseDAO implements UserDAO {


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

    public User getById(Long id){
        return getSessionFactory().getCurrentSession().load(User.class, id);
    }

    @Override
    public User getByUserName(String login) {
        List<User> userList;
        userList = getSessionFactory().getCurrentSession().
                createQuery("from by.jum.internetbanking.entity.User where login=?").setParameter(0, login).list();

        if (userList.size() > 0) {
            return userList.get(0);
        } else {
            return null;
        }
    }
}