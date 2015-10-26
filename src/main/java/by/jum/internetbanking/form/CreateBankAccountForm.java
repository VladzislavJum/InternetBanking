package by.jum.internetbanking.form;

public class CreateBankAccountForm {
    private Long bankAccountID;
    private Integer accountNumber;
    private Long amountOfMoney;
    private String userLogin;

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public Long getBankAccountID() {
        return bankAccountID;
    }

    public void setBankAccountID(Long bankAccountID) {
        this.bankAccountID = bankAccountID;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(Long amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }
}
