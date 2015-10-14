package by.jum.internetbanking.dao.impl;

import by.jum.internetbanking.dao.CardDAO;
import by.jum.internetbanking.enity.Card;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardDAOImpl implements CardDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCard(Card card) {
        sessionFactory.getCurrentSession().save(card);
    }

    public List<Card> getCards() {
        return sessionFactory.getCurrentSession().createQuery("from by.jum.internetbanking.enity.Card")
                .list();
    }

}
