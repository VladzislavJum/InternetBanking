package by.jum.internetbanking.service;

import by.jum.internetbanking.entity.BankAccount;
import by.jum.internetbanking.entity.Card;
import by.jum.internetbanking.entity.User;

import java.util.List;

public interface UserService {
    void registerUser(User user);

    void deleteUser(User user);

    List<User> getUserList();

    User getUserByID(long userID);

    List<Card> getUserCardList(String login);

    List<BankAccount> getUserAccountList(String login);

}
