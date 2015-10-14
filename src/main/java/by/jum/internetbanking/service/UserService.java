package by.jum.internetbanking.service;

import by.jum.internetbanking.enity.User;

/**
 * Created by Vlad on 13.10.2015.
 */

public interface UserService {
    void addUser(User user);
    void pay();
    void lockCard();
    void unlockCard();
}
