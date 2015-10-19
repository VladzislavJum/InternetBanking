package by.jum.internetbanking.facade.converter;

import by.jum.internetbanking.dto.CardDTO;
import by.jum.internetbanking.entity.Card;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class CardConverter{

    public CardDTO convertToCardDTO(Card card) {
        CardDTO cardDTO = new CardDTO();
        cardDTO.setPinCode(card.getPinCode());
        //cardDTO.setUserDTO(card.getUser());

        return cardDTO;
    }

    public Card convertToCard(CardDTO cardDTO){
        Card card = new Card();
      //  card.setUser(cardDTO.getUserDTO());
        card.setPinCode(cardDTO.getPinCode());

        return card;
    }
}
