package by.jum.internetbanking.service;

import by.jum.internetbanking.enity.Card;

import java.util.List;

/**
 * Created by Vlad on 13.10.2015.
 */

public interface CardService {
    void addCard(Card card);

    List<Card> getCards();
}
