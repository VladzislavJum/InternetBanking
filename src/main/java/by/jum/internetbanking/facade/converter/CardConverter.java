package by.jum.internetbanking.facade.converter;

import by.jum.internetbanking.dto.CardDTO;
import by.jum.internetbanking.entity.Card;
import by.jum.internetbanking.form.CreateCardForm;
import org.springframework.stereotype.Component;


@Component
public class CardConverter{

    public CardDTO convertCardToDTO(Card card) {
        CardDTO cardDTO = new CardDTO();
        cardDTO.setPinCode(card.getPinCode());

        return cardDTO;
    }

    public Card convertDTOToCard(CardDTO cardDTO){
        Card card = new Card();
        card.setPinCode(cardDTO.getPinCode());

        return card;
    }

    public Card convertFormToCard(CreateCardForm createCardForm){
        Card card = new Card();
        card.setPinCode(createCardForm.getPinCode());

        return card;
    }
}