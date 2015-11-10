package by.jum.internetbanking.form.history;

import java.math.BigDecimal;

public class PaymentHistoryForm {
    private long paymentHistoryID;
    private String accountNumberFrom;
    private String accountNumberTo;
    private BigDecimal amountOfMoney;

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

    public String getAccountNumberTo() {
        return accountNumberTo;
    }

    public void setAccountNumberTo(String accountNumberTo) {
        this.accountNumberTo = accountNumberTo;
    }

    public BigDecimal getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(BigDecimal amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }
}
