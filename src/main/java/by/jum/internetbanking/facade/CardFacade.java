package by.jum.internetbanking.facade;


import by.jum.internetbanking.dto.CardDTO;

import java.util.List;

public interface CardFacade {
    void createCard(CardDTO cardDTO);

    CardDTO getCardByID(long cardID);

    List<CardDTO> getCardList();

}
