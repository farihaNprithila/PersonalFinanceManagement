package com.prithila.personalfinancemanagement.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @author Prithila
 * @since 9/19/2021
 */

@Entity
@Table(name = "bankaccount")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "total_balance")
    private Long totalBalance;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "transaction_date")
    private Date transactionDate = new Date();

    public BankAccount() {
    }

    public BankAccount(String accountNumber, String transactionType, Long amount, Long totalBalance) {
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
        this.totalBalance = totalBalance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(Long totalBalance) {
        this.totalBalance = totalBalance;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
