package by.jum.internetbanking.dto;

import java.math.BigDecimal;

public class PaymentHistoryDTO {
    private long paymentHistoryID;
    private String accountNumberFrom;
    private String objectTo;
    private BigDecimal amountOfMoney;
    private long userID;
    private String dateTime;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getPaymentHistoryID() {
        return paymentHistoryID;
    }

    public void setPaymentHistoryID(long paymentHistoryID) {
        this.paymentHistoryID = paymentHistoryID;
    }

    public String getAccountNumberFrom() {
        return accountNumberFrom;
    }

    public void setAccountNumberFrom(String accountNumberFrom) {
        this.accountNumberFrom = accountNumberFrom;
    }

    public String getObjectTo() {
        return objectTo;
    }

    public void setObjectTo(String objectTo) {
        this.objectTo = objectTo;
    }

    public BigDecimal getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(BigDecimal amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }
}
