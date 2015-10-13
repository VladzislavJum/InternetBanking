package dao;

import entity.Card;

import java.util.List;

public interface CardDAO {
    void addCard(Card card);

    List<Card> getCards();

}
