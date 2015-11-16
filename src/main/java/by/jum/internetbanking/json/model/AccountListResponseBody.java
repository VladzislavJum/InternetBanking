package by.jum.internetbanking.json.model;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.json.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;

public class AccountListResponseBody {

    @JsonView(Views.Public.class)
    List<BankAccountDTO> accountDTOList;

    public List<BankAccountDTO> getAccountDTOList() {
        return accountDTOList;
    }

    public void setAccountDTOList(List<BankAccountDTO> accountDTOList) {
        this.accountDTOList = accountDTOList;
    }
}
