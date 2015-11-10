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
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "payment_history")
public class PaymentHistory implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historyID;

    @JoinColumn(name = "account_from_id")
    private BankAccount accountFrom;

    @JoinColumn(name = "account_to_id")
    private BankAccount accountTo;

    @Column(name = "amount_of_money")
    private BigDecimal amountOfMoney;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Long getHistoryID() {
        return historyID;
    }

    public void setHistoryID(Long historyID) {
        this.historyID = historyID;
    }

    public BankAccount getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(BankAccount accountFrom) {
        this.accountFrom = accountFrom;
    }

    public BankAccount getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(BankAccount accountTo) {
        this.accountTo = accountTo;
    }

    public BigDecimal getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(BigDecimal amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }
}
