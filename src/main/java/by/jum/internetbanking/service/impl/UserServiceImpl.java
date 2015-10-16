package by.jum.internetbanking.service.impl;

import by.jum.internetbanking.dao.UserDAO;
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


    @Transactional
    public void registerUser(User user) {
        userDAO.save(user);
    }

    @Transactional
    public void deleteUser(User user) {

    }

    @Transactional
    public List<User> getUserList() {
        return null;
    }

    public User getUserByID(long userID) {
        return null;
    }
}
