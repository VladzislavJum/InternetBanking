package by.jum.internetbanking.facade.impl;

import by.jum.internetbanking.entity.BankAccount;
import by.jum.internetbanking.entity.Corporation;
import by.jum.internetbanking.facade.CorporationFacade;
import by.jum.internetbanking.form.money.PaymentForServicesForm;
import by.jum.internetbanking.service.BankAccountService;
import by.jum.internetbanking.service.CorporationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Locale;

@Component("corporationUtilitiesFacade")
public class CorporationUtilitiesFacadeImpl implements CorporationFacade {

    private static final Logger LOGGER = Logger.getLogger(CorporationUtilitiesFacadeImpl.class);
    private static final int ELECTRICITY_TARIFF = 1000;
    private static final int WATER_TARIFF = 1500;
    private static final int GAS_TARIFF = 850;

    @Autowired
    private BankAccountService accountService;

    @Autowired
    private CorporationService corporationService;

    @Autowired
    private MessageSource messageSource;

    @Override
    public Corporation getByName(String name) {
        return corporationService.getByName(name);
    }

    @Override
    public void transferMoney(PaymentForServicesForm servicesForm) {
        String numberAccountFrom = servicesForm.getNumberAccountFrom();
        String name = servicesForm.getNameCorp();
        String amount = servicesForm.getAmount();

        BigDecimal transferredAmount = new BigDecimal(amount);
        if (name.equals("Electricity")) {
            transferredAmount = transferredAmount.multiply(new BigDecimal(ELECTRICITY_TARIFF));
        } else if (name.equals("Water")) {
            transferredAmount = transferredAmount.multiply(new BigDecimal(WATER_TARIFF));
        } else {
            transferredAmount = transferredAmount.multiply(new BigDecimal(GAS_TARIFF));
        }
        servicesForm.setAmountOfMoney(transferredAmount.toString());
        BankAccount accountFrom = accountService.getAccountByNumber(numberAccountFrom);
        BankAccount accountTo = corporationService.getByName(name).getAccount();

        LOGGER.info(messageSource.getMessage("print.transfer", new Object[]{transferredAmount,
                numberAccountFrom, accountTo}, Locale.ENGLISH));
        accountService.transferMoney(accountFrom, accountTo, transferredAmount);
    }
}
