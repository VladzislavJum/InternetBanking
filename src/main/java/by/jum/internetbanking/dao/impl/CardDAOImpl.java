package by.jum.internetbanking.dao.impl;

import by.jum.internetbanking.dao.CardDAO;
import by.jum.internetbanking.entity.Card;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardDAOImpl extends AbstractBaseDAO implements CardDAO {

    public void delete(Card card) {
        super.delete(card);
    }

    public void update(Card card) {
        super.update(card);
    }

    public void save(Card card) {
        super.save(card);
    }

    public List<Card> getList() {
        return getSessionFactory().getCurrentSession().createQuery("from by.jum.internetbanking.entity.Card").list();
    }

    public void lock() {
//      getSessionFactory().getCurrentSession().createQuery("");
    }

    public void unlock() {

    }

    public Card getByID(Long id) {
        return (Card) super.getByID(Card.class, id);
    }
}
