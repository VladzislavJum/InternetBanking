package by.jum.internetbanking.service;

import by.jum.internetbanking.entity.Card;
import by.jum.internetbanking.entity.User;

import java.util.List;

/**
 * Created by Vlad on 13.10.2015.
 */

public interface CardService {
    void createCard(Card card);
    void deleteCard(Card card);
    List<User> getCardList();
}
