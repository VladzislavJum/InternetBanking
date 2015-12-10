package by.jum.internetbanking.dto;

import by.jum.internetbanking.util.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;

public class BankAccountDTO implements Serializable {

    @JsonView(Views.Account.class)
    private Long bankAccountID;
    @JsonView(Views.Account.class)
    private String accountNumber;
    private String amountOfMoney;
    private long userID;

    public Long getBankAccountID() {
        return bankAccountID;
    }

    public void setBankAccountID(Long bankAccountID) {
        this.bankAccountID = bankAccountID;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(String amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }
}
