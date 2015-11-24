package by.jum.internetbanking.service.impl;

import by.jum.internetbanking.dao.BankAccountDAO;
import by.jum.internetbanking.dao.CorporationDAO;
import by.jum.internetbanking.entity.BankAccount;
import by.jum.internetbanking.entity.Corporation;
import by.jum.internetbanking.service.CorporationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class CorporationServiceImpl implements CorporationService{

    @Autowired
    private CorporationDAO corporationDAO;

    @Autowired
    private BankAccountDAO accountDAO;

    @Override
    @Transactional
    public Corporation getByID(Long id) {
        return corporationDAO.getByID(id);
    }

    @Override
    @Transactional
    public Corporation getByName(String name) {
        return corporationDAO.getByName(name);
    }

    @Override
    @Transactional
    public void transferMoney(BankAccount accountFrom, Corporation corporation, BigDecimal amountOfTransferredMoney) {
        accountFrom.setAmountOfMoney(accountFrom.getAmountOfMoney().subtract(amountOfTransferredMoney));
        corporation.setAmountOfMoney(corporation.getAmountOfMoney().add(amountOfTransferredMoney));
        accountDAO.update(accountFrom);
        corporationDAO.update(corporation);
    }
}
