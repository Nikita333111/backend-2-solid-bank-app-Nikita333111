package com.example.demo.entity.account;

import com.example.demo.AccountType;
import com.example.demo.entity.transaction.Transaction;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@Table(name = "Account")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("account")
public class Account {
    @Id
    private String accountId;
    @Enumerated
    private AccountType accountType;
    @Column(name = "client_id")
    private String clientID;
    private double balance;
    @Column(name = "withdraw_allowed")
    private boolean withdrawAllowed;

    @OneToMany(mappedBy = "accountId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions = new ArrayList<>();


    public Account() {}

    public Account(String accountId, AccountType accountType, String clientID, double balance, boolean withdrawAllowed, List<Transaction> transactions) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.clientID = clientID;
        this.balance = balance;
        this.withdrawAllowed = withdrawAllowed;
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }
}
