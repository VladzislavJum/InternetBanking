package dao.impl;

import dao.CardDAO;
import domain.Card;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
        return sessionFactory.getCurrentSession().createQuery("from domain.Card")
                .list();
    }

}
