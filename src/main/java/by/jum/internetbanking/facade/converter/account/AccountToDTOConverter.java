package by.jum.internetbanking.facade.converter.account;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.entity.BankAccount;
import by.jum.internetbanking.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AccountToDTOConverter implements Converter<BankAccount, BankAccountDTO> {
    @Override
    public BankAccountDTO convert(BankAccount account) {
        BankAccountDTO accountDTO = new BankAccountDTO();
        accountDTO.setAccountNumber(account.getAccountNumber());
        accountDTO.setAmountOfMoney(account.getAmountOfMoney());
        accountDTO.setBankAccountID(account.getBankAccountID());
        User user = account.getUser();
        if (user != null) {
            accountDTO.setUserID(account.getUser().getUserID());
        }
        return accountDTO;
    }
}
