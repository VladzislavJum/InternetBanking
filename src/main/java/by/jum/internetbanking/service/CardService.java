package by.jum.internetbanking.service;

import by.jum.internetbanking.entity.Card;
import by.jum.internetbanking.entity.User;

import java.util.List;

public interface CardService {
    void createCard(Card card);
    void deleteCard(Card card);
    List<Card> getCardList();
    Card getCardByID(long cardID);

}
