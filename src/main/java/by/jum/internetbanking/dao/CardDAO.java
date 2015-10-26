package by.jum.internetbanking.dao;


import by.jum.internetbanking.entity.Card;

import java.util.List;

public interface CardDAO {
    List<Card> getList();

    void save(Card card);

    void update(Card card);

    void delete(Card card);

    void lock();

    void unlock();

    Card getByID(Long id);
}
