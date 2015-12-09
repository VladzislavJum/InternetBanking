package by.jum.internetbanking.form.money;

public class PaymentForServicesForm {
    private String amountOfMoney;
    private String nameCorp;
    private String numberAccountFrom;
    private String numberCorporationAcc;
    private String phoneNumber;
    private long userID;
    private boolean isPhone;
    private String amount;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNumberCorporationAcc() {
        return numberCorporationAcc;
    }

    public void setNumberCorporationAcc(String numberCorporationAcc) {
        this.numberCorporationAcc = numberCorporationAcc;
    }


    public boolean isPhone() {
        return isPhone;
    }

    public void setIsPhone(boolean isPhone) {
        this.isPhone = isPhone;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(String amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public String getNameCorp() {
        return nameCorp;
    }

    public void setNameCorp(String nameCorp) {
        this.nameCorp = nameCorp;
    }

    public String getNumberAccountFrom() {
        return numberAccountFrom;
    }

    public void setNumberAccountFrom(String numberAccountFrom) {
        this.numberAccountFrom = numberAccountFrom;
    }
}
