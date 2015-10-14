package service.impl;

import dao.CardDAO;
import domain.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.CardService;

import java.util.List;


@Service
public class CardServiceImpl implements CardService{

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
