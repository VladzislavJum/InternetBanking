package by.jum.internetbanking.service.impl;

import by.jum.internetbanking.dao.CardDAO;
import by.jum.internetbanking.enity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import by.jum.internetbanking.service.CardService;

import java.util.List;

@Service
public class CardServiceImpl implements CardService{

    @Autowired
    private CardDAO cardDAO;

    @Transactional
    public void addCard(Card card) {
        cardDAO.addCard(card);
    }

    @Transactional
    public List<Card> getCards() {
        return cardDAO.getCards();
    }
}
