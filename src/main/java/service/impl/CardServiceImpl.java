package service.impl;

import dao.CardDAO;
import entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.CardService;

/**
 * Created by Vlad on 13.10.2015.
 */

@Service
public class CardServiceImpl implements CardService{

    @Autowired
    private CardDAO cardDAO;

    @Transactional
    public void addCard(Card card) {
        cardDAO.addCard(card);
    }
}
