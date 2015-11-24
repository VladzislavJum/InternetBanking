package by.jum.internetbanking.dto;

import by.jum.internetbanking.json.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;

import java.math.BigDecimal;

public class BankAccountDTO {
    @JsonView(Views.Account.class)
    private long bankAccountID;
    @JsonView(Views.Account.class)
    private String accountNumber;
    @JsonView(Views.Account.class)
    private BigDecimal amountOfMoney;
    private long userID;

    public void setBankAccountID(long bankAccountID) {
        this.bankAccountID = bankAccountID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

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

    public BigDecimal getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(BigDecimal amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }
}
