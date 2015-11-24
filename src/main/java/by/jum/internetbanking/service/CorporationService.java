package by.jum.internetbanking.service;


import by.jum.internetbanking.entity.BankAccount;
import by.jum.internetbanking.entity.Corporation;

import java.math.BigDecimal;

public interface CorporationService {
    Corporation getByID(Long id);

    Corporation getByName(String name);

    void transferMoney(BankAccount accountFrom, Corporation corporation, BigDecimal amountOfTransferredMoney);
}
