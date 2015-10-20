package by.jum.internetbanking.facade.impl;

import by.jum.internetbanking.dto.CardDTO;
import by.jum.internetbanking.entity.Card;
import by.jum.internetbanking.facade.CardFacade;
import by.jum.internetbanking.facade.converter.CardConverter;
import by.jum.internetbanking.form.CreateCardForm;
import by.jum.internetbanking.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("cardFacade")
public class CardFacadeImpl implements CardFacade {

    @Autowired
    private CardService cardService;

    @Autowired
    private CardConverter cardConverter;

    @Override
    public void createCard(CreateCardForm createCardForm) {
        cardService.createCard(cardConverter.convertFormToCard(createCardForm));
    }

    @Override
    public CardDTO getCardByID(long cardID) {
        return cardConverter.convertCardToDTO(cardService.getCardByID(cardID));
    }

    @Override
    public List<CardDTO> getCardList() {

        List<CardDTO> cardDTOList = new ArrayList<>();
        List<Card> cardList = cardService.getCardList();

        cardList.forEach(card -> cardDTOList.add(cardConverter.convertCardToDTO(card)));
        return cardDTOList;

    }
}
