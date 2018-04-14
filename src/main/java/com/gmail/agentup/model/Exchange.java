package com.gmail.agentup.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Exchanges")
public class Exchange {
    @Id
    @GeneratedValue
    private long id;
    private double rate;
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @OneToMany(mappedBy = "exchange", cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();

    public Exchange(double rate, Date date) {
        this.rate = rate;
        this.date = date;
    }

    public Exchange() {
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        transaction.setExchange(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
