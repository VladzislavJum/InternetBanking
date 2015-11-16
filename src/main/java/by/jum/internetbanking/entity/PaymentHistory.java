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

    @Column(name = "number_account_from")
    private String numberAccountFrom;

    @Column(name = "number_account_to")
    private String numberAccountTo;

    @Column(name = "amount_of_money")
    private BigDecimal amountOfMoney;

    @Column(name = "data_time")
    private String dataTime;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public Long getHistoryID() {
        return historyID;
    }

    public void setHistoryID(Long historyID) {
        this.historyID = historyID;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(BigDecimal amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }
}
