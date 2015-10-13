package dao;

import entity.User;

import java.util.List;


public interface UserDAO {

    List<User> getUsers();

    void addUser(User user);

    void pay();

    void lockCard();

    void unlockCard();
}
