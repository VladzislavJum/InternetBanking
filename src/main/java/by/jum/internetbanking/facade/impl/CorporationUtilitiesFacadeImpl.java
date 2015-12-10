package by.jum.internetbanking.facade.impl;

import by.jum.internetbanking.entity.BankAccount;
import by.jum.internetbanking.entity.Corporation;
import by.jum.internetbanking.facade.CorporationFacade;
import by.jum.internetbanking.form.money.PaymentForServicesForm;
import by.jum.internetbanking.service.BankAccountService;
import by.jum.internetbanking.service.CorporationService;
import by.jum.internetbanking.util.TariffConstants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Locale;

@Component("corporationUtilitiesFacade")
public class CorporationUtilitiesFacadeImpl implements CorporationFacade {

    private static final Logger LOGGER = Logger.getLogger(CorporationUtilitiesFacadeImpl.class);

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
            transferredAmount = transferredAmount.multiply(new BigDecimal(TariffConstants.ELECTRICITY_TARIFF.getTariff()));
        } else if (name.equals("Water")) {
            transferredAmount = transferredAmount.multiply(new BigDecimal(TariffConstants.WATER_TARIFF.getTariff()));
        } else {
            transferredAmount = transferredAmount.multiply(new BigDecimal(TariffConstants.GAS_TARIFF.getTariff()));
        }
        servicesForm.setAmountOfMoney(transferredAmount.toString());
        BankAccount accountFrom = accountService.getAccountByNumber(numberAccountFrom);
        BankAccount accountTo = corporationService.getByName(name).getAccount();

        LOGGER.info(messageSource.getMessage("print.transfer", new Object[]{transferredAmount,
                numberAccountFrom, accountTo}, Locale.ENGLISH));
        accountService.transferMoney(accountFrom, accountTo, transferredAmount);
    }
}
