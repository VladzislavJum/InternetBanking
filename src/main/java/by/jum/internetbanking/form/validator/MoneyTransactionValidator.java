package by.jum.internetbanking.form.validator;

import by.jum.internetbanking.form.money.MoneyTransactionForm;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MoneyTransactionValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return MoneyTransactionForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MoneyTransactionForm transactionForm = (MoneyTransactionForm) target;
        if (StringUtils.isEmpty(transactionForm.getNumberAccountFrom())) {
            errors.rejectValue("numberAccountFrom", "moneytrans.label.error.requiredaccount");
        }
    }
}
