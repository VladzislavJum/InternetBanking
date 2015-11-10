package by.jum.internetbanking.form.money;

public class MoneyTransactionForm {
    private String numberAccountFrom;
    private String numberAccountTo;

    private String amountOfTransferredMoney;

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

    public String getNumberAccountTo() {
        return numberAccountTo;
    }

    public void setNumberAccountTo(String numberAccountTo) {
        this.numberAccountTo = numberAccountTo;
    }
}
