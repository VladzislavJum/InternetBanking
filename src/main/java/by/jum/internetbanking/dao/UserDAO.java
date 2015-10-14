package by.jum.internetbanking.dao;

import by.jum.internetbanking.enity.User;

import java.util.List;


public interface UserDAO {

    List<User> getUsers();

    void addUser(User user);

    void pay();

    void lockCard();

    void unlockCard();
}
