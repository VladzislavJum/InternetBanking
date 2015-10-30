package by.jum.internetbanking.facade.converter.account;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.entity.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountListToDTOListConverter implements Converter<List<BankAccount>, List<BankAccountDTO>> {

    @Autowired
    private Converter accountToDTOConverter;

    @Override
    public List<BankAccountDTO> convert(List<BankAccount> accountList) {
        List<BankAccountDTO> accountDTOList = new ArrayList<>();
        accountList.forEach(account -> accountDTOList.add((BankAccountDTO) accountToDTOConverter.convert(account)));
        return accountDTOList;
    }
}
