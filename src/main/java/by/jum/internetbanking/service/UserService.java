package by.jum.internetbanking.service;

import by.jum.internetbanking.entity.User;

import java.util.List;

public interface UserService {
    void registerUser(User user);

    void deleteUser(User user);

    List<User> getUserList();

    User getUserByID(long userID);

    User getByUserName(String login);

    void deleteById(long id);

    boolean isExistUserWithPassportNumber(String passportNumber);

    long getIDCurrentUser();

    void lockOrUnlockUser(long id);
}
