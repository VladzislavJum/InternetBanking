package by.jum.internetbanking.facade.converter;

import by.jum.internetbanking.dto.CardDTO;
import by.jum.internetbanking.entity.Card;
import by.jum.internetbanking.form.CreateCardForm;
import by.jum.internetbanking.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CardConverter {
    private final Logger LOGGER = Logger.getLogger(getClass());

    @Autowired
    private UserService userService;

    public CardDTO convertCardToDTO(Card card) {
        CardDTO cardDTO = new CardDTO();
        cardDTO.setPinCode(card.getPinCode());
        cardDTO.setCardID(card.getCardID());
        cardDTO.setCardNumber(card.getCardNumber());

        return cardDTO;
    }

    public Card convertDTOToCard(CardDTO cardDTO) {
        Card card = new Card();
        card.setPinCode(cardDTO.getPinCode());

        return card;
    }

    public Card convertFormToCard(CreateCardForm createCardForm) {
        Card card = new Card();
        card.setPinCode(createCardForm.getPinCode());
        card.setCardNumber(createCardForm.getCardNumber());

        card.setUser(userService.getUserByID(67L));

        LOGGER.warn("user " + card.getUser().getUserID());

        return card;
    }

    public List<CardDTO> convertCardListToDTOList(List<Card> cardList) {
        List<CardDTO> cardDTOList = new ArrayList<>();
        cardList.forEach(card -> cardDTOList.add(convertCardToDTO(card)));
        return cardDTOList;
    }
}