package by.jum.internetbanking.dao;

import by.jum.internetbanking.entity.User;

import java.util.List;


public interface UserDAO {

    List<User> getList();

    void save(User user);

    void update(User user);

    void delete(User user);

    User getById(Long id);

    User getByUserName(String login);

    List<User> findListByLogin(String login);

    void deleteByID(long id);

    boolean isExistUserWithPassportNumber(String passportNumber);

    void lockOrUnlock(long id);
}
