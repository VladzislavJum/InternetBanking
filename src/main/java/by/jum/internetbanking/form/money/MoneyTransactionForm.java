package by.jum.internetbanking.form.money;

public class MoneyTransactionForm {
    private String numberAccountFrom;
    private String objectTo;
    private String amountOfTransferredMoney;
    private long userID;

    public String getAmountOfTransferredMoney() {
        return amountOfTransferredMoney;
    }

    public void setAmountOfTransferredMoney(String amountOfTransferredMoney) {
        this.amountOfTransferredMoney = amountOfTransferredMoney;
    }

    public String getNumberAccountFrom() {
        return numberAccountFrom;
    }

    public void setNumberAccountFrom(String numberAccountFrom) {
        this.numberAccountFrom = numberAccountFrom;
    }

    public String getObjectTo() {
        return objectTo;
    }

    public void setObjectTo(String objectTo) {
        this.objectTo = objectTo;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }
}
