package by.jum.internetbanking.facade;


import by.jum.internetbanking.entity.Corporation;
import by.jum.internetbanking.form.money.PaymentForServicesForm;

public interface CorporationFacade {
    Corporation getByName(String name);

    void transferMoney(PaymentForServicesForm servicesForm);
}
