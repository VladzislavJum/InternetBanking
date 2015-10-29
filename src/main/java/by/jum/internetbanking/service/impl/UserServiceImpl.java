package by.jum.internetbanking.service.impl;

import by.jum.internetbanking.dao.UserDAO;
import by.jum.internetbanking.entity.BankAccount;
import by.jum.internetbanking.entity.User;
import by.jum.internetbanking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public void registerUser(User user) {
        userDAO.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userDAO.delete(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getUserList() {
        return userDAO.getList();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByID(long userID) {
        return userDAO.getById(userID);
    }

    @Override
    @Transactional(readOnly = true)
    public User getByUserName(String login) {
        return userDAO.getByUserName(login);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BankAccount> getUserAccountList(String login) {
        return userDAO.getAccountUserList(login);
    }
}
