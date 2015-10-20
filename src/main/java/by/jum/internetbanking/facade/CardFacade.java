package by.jum.internetbanking.facade;


import by.jum.internetbanking.dto.CardDTO;
import by.jum.internetbanking.form.CreateCardForm;

import java.util.List;

public interface CardFacade {
    void createCard(CreateCardForm createCardForm);

    CardDTO getCardByID(long cardID);

    List<CardDTO> getCardList();

}
