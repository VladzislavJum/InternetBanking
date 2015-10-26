package by.jum.internetbanking.service.impl;

import by.jum.internetbanking.dao.CardDAO;
import by.jum.internetbanking.entity.Card;
import by.jum.internetbanking.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("cardService")
public class CardServiceImpl implements CardService {

    @Autowired
    private CardDAO cardDAO;

    @Override
    @Transactional
    public void createCard(Card card) {
        cardDAO.save(card);
    }

    @Override
    @Transactional
    public void deleteCard(Card card) {
        cardDAO.delete(card);
    }

    @Override
    @Transactional
    public List<Card> getCardList() {
        return cardDAO.getList();
    }

    @Override
    @Transactional
    public Card getCardByID(long cardID) {
        return cardDAO.getByID(cardID);
    }
}
