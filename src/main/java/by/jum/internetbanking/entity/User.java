package by.jum.internetbanking.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = {"passport_number", "login"}))
public class User implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @Column(name = "name")
    private String firstname;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "passport_number")
    private String passportNumber;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "unlocked")
    private boolean isUnlocked = true;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "user")
    private List<BankAccount> bankAccountList;

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "user", orphanRemoval = true)
    private List<PaymentHistory> paymentHistoryList;

    public void setIsUnlocked(boolean isUnlocked) {
        this.isUnlocked = isUnlocked;
    }

    public List<PaymentHistory> getPaymentHistoryList() {
        return paymentHistoryList;
    }

    public void setPaymentHistoryList(List<PaymentHistory> paymentHistoryList) {
        this.paymentHistoryList = paymentHistoryList;
    }

    public List<BankAccount> getBankAccountList() {
        return bankAccountList;
    }

    public void setBankAccountList(List<BankAccount> bankAccountList) {
        this.bankAccountList = bankAccountList;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isUnlocked() {
        return isUnlocked;
    }

    public void setIsEnabled(boolean isEnabled) {
        this.isUnlocked = isEnabled;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}
