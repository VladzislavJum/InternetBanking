package by.jum.internetbanking.service.impl;

import by.jum.internetbanking.dao.CardDAO;
import by.jum.internetbanking.entity.Card;
import by.jum.internetbanking.entity.User;
import by.jum.internetbanking.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardDAO cardDAO;

    @Transactional
    public void createCard(Card card) {
        cardDAO.save(card);
    }

    @Transactional
    public void deleteCard(Card card) {
        cardDAO.delete(card);
    }

    @Transactional
    public List<User> getCardList() {
        return null;
    }
}
