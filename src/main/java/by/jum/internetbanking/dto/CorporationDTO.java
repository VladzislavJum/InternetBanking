package by.jum.internetbanking.dto;

public class CorporationDTO {
    private long corporationID;
    private String name;
    private long accountID;

    public long getCorporationID() {
        return corporationID;
    }

    public void setCorporationID(long corporationID) {
        this.corporationID = corporationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAccountID() {
        return accountID;
    }

    public void setAccountID(long accountID) {
        this.accountID = accountID;
    }
}
