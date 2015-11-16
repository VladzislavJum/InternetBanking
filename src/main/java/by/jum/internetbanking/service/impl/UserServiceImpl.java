package by.jum.internetbanking.service.impl;

import by.jum.internetbanking.dao.UserDAO;
import by.jum.internetbanking.entity.BankAccount;
import by.jum.internetbanking.entity.PaymentHistory;
import by.jum.internetbanking.entity.User;
import by.jum.internetbanking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
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
    public List<BankAccount> getUserAccountList(long id) {
        return userDAO.getAccountUserList(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PaymentHistory> getHistoryUserList(long id) {
        return userDAO.getHistoryUserList(id);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        userDAO.deleteByID(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isExistUserWithPassportNumber(String passportNumber) {
        return userDAO.isExistUserWithPassportNumber(passportNumber);
    }

    @Override
    @Transactional(readOnly = true)
    public long getIDCurrentUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        return getByUserName(username).getUserID();
    }

    @Override
    @Transactional
    public void lockOrUnlockUser(long id) {
        userDAO.lockOrUnlock(id);
    }
}
