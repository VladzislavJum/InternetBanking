package by.jum.internetbanking.form.validator;

import by.jum.internetbanking.form.money.PaymentForServicesForm;
import by.jum.internetbanking.service.CorporationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PaymentForServicesValidator implements Validator {

    @Autowired
    private MoneyTransactionValidator moneyTransactionValidator;

    @Autowired
    private CorporationService corporationService;

    @Override
    public boolean supports(Class<?> clazz) {
        return PaymentForServicesForm.class.isAssignableFrom(clazz);

    }

    @Override
    public void validate(Object target, Errors errors) {
        PaymentForServicesForm servicesForm = (PaymentForServicesForm) target;

        if (corporationService.getByName(servicesForm.getNameCorp()) == null) {
            errors.rejectValue("nameCorp", "paymentserv.label.namecorp");
        } else {
            if (StringUtils.isEmpty(servicesForm.getNumberAccountFrom())) {
                errors.rejectValue("accountNumberFrom", "moneytrans.label.error.requiredaccount");
            } else {
                moneyTransactionValidator.checkAmountOfMoney(servicesForm.getAmountOfMoney(), servicesForm.getNumberAccountFrom(), errors, "amountOfMoney");
            }
        }
    }
}
