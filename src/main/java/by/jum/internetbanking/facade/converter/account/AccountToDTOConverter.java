package by.jum.internetbanking.facade.converter.account;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.entity.BankAccount;
import by.jum.internetbanking.entity.User;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

@Component
public class AccountToDTOConverter implements Converter<BankAccount, BankAccountDTO> {



    @Override
    public BankAccountDTO convert(BankAccount account) {
        BankAccountDTO accountDTO = new BankAccountDTO();
        accountDTO.setAccountNumber(account.getAccountNumber());

        NumberFormat numberFormat = NumberFormat.getNumberInstance(LocaleContextHolder.getLocale());

        accountDTO.setAmountOfMoney(numberFormat.format(account.getAmountOfMoney()));
        accountDTO.setBankAccountID(account.getBankAccountID());
        User user = account.getUser();
        if (user != null) {
            accountDTO.setUserID(account.getUser().getUserID());
        }
        return accountDTO;
    }
}
