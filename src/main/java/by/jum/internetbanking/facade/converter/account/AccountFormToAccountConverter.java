package by.jum.internetbanking.facade.converter.account;

import by.jum.internetbanking.entity.BankAccount;
import by.jum.internetbanking.form.account.CreateBankAccountForm;
import by.jum.internetbanking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AccountFormToAccountConverter implements Converter<CreateBankAccountForm, BankAccount> {

    @Autowired
    private UserService userService;

    @Override
    public BankAccount convert(CreateBankAccountForm accountForm) {
        BankAccount account = new BankAccount();
        account.setAccountNumber(Integer.valueOf(accountForm.getAccountNumber()));
        account.setAmountOfMoney(new BigDecimal(accountForm.getAmountOfMoney()));
        account.setUser(userService.getByUserName(accountForm.getUserLogin()));
        return account;
    }
}
