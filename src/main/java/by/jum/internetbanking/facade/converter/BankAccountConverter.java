package by.jum.internetbanking.facade.converter;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.entity.BankAccount;
import by.jum.internetbanking.form.CreateBankAccountForm;
import by.jum.internetbanking.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BankAccountConverter {
    private final Logger LOGGER = Logger.getLogger(getClass());

    @Autowired
    private UserService userService;

    public BankAccountDTO convertAccountToDTO(BankAccount account) {
        BankAccountDTO accountDTO = new BankAccountDTO();
        accountDTO.setAccountNumber(account.getAccountNumber());
        accountDTO.setAmountOfMoney(account.getAmountOfMoney());
        accountDTO.setBankAccountID(account.getBankAccountID());

        return accountDTO;
    }

    public BankAccount convertDTOToAccount(BankAccountDTO accountDTO) {
        BankAccount account = new BankAccount();
        account.setAmountOfMoney(accountDTO.getAmountOfMoney());
        account.setAccountNumber(accountDTO.getAccountNumber());
        return account;
    }

    public BankAccount convertFormToAccount(CreateBankAccountForm accountForm) {
        BankAccount account = new BankAccount();
        account.setAccountNumber(accountForm.getAccountNumber());
        account.setAmountOfMoney(accountForm.getAmountOfMoney());
        account.setUser(userService.getUserByID(65));
//        account.setType();
        return account;
    }

    public List<BankAccountDTO> convertAccountListToDTOAccountList(List<BankAccount> accountList) {
        List<BankAccountDTO> accountDTOList = new ArrayList<>();
        accountList.forEach(account -> accountDTOList.add(convertAccountToDTO(account)));
        return accountDTOList;
    }
}
