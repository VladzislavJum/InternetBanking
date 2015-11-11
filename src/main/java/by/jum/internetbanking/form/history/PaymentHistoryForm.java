package by.jum.internetbanking.form.history;

public class PaymentHistoryForm {
    private long paymentHistoryID;
    private String accountNumberFrom;
    private String accountNumberTo;
    private String amountOfMoney;

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

    public String getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(String amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }
}
