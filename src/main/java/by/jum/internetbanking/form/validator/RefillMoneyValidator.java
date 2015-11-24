package by.jum.internetbanking.form.validator;

import by.jum.internetbanking.form.money.RefillMoneyForm;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class RefillMoneyValidator implements Validator {

    private static final String MONEY_PATTERN = "[0-9]+";

    @Override
    public boolean supports(Class<?> clazz) {
        return RefillMoneyForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RefillMoneyForm refillMoneyForm = (RefillMoneyForm) target;
        String amountOfMoney = refillMoneyForm.getAmountOfMoney();

        if (StringUtils.isEmpty(amountOfMoney)) {
            errors.rejectValue("amountOfMoney", "common.label.error.emptyfield");
        } else if (amountOfMoney.length() > 10 || amountOfMoney.length() < 3) {
            errors.rejectValue("amountOfMoney", "createaccount.label.error.amounofmoneysize");
        } else {
            Pattern pattern = Pattern.compile(MONEY_PATTERN);
            Matcher matcher = pattern.matcher(amountOfMoney);
            if (!matcher.matches()) {
                errors.rejectValue("amountOfMoney", "common.label.error.numeric");
            }
        }
    }
}
