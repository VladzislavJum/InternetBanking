package by.jum.internetbanking.dao;


import by.jum.internetbanking.enity.Card;

import java.util.List;

public interface CardDAO {
    void addCard(Card card);

    List getCards();

}
