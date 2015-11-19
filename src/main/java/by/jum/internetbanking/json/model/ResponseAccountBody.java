package by.jum.internetbanking.json.model;

import by.jum.internetbanking.dto.BankAccountDTO;
import by.jum.internetbanking.json.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;

public class ResponseAccountBody {
    @JsonView(Views.Public.class)
    BankAccountDTO bankAccountDTO;

    public BankAccountDTO getBankAccountDTO() {
        return bankAccountDTO;
    }

    public void setBankAccountDTO(BankAccountDTO bankAccountDTO) {
        this.bankAccountDTO = bankAccountDTO;
    }
}
