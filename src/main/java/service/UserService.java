package service;

import entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by Vlad on 13.10.2015.
 */

public interface UserService {
    void addUser(User user);
    void pay();
    void lockCard();
    void unlockCard();
}
