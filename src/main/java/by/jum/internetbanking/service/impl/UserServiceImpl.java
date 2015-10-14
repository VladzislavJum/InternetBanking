package by.jum.internetbanking.service.impl;

import by.jum.internetbanking.dao.UserDAO;
import by.jum.internetbanking.enity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import by.jum.internetbanking.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }
    @Transactional
    public void pay() {
        userDAO.pay();
    }
    @Transactional
    public void lockCard() {
        userDAO.lockCard();
    }
    @Transactional
    public void unlockCard() {
        userDAO.unlockCard();
    }
}
