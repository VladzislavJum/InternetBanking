package dao;

import domain.Card;

import java.util.List;

public interface CardDAO {
    void addCard(Card card);

    List getCards();

}
