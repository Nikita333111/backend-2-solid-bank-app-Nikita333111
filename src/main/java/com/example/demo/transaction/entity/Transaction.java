package com.example.demo.transaction.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    @Column(name = "account_id")
    private String accountId;
    private double amount;
    @Column(name = "client_id")
    private String clientID;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "transaction_type")
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    public Transaction(String accountID, double amount, String clientID, Date createdAt, TransactionType transactionType) {
        this.accountId = accountID;
        this.amount = amount;
        this.clientID = clientID;
        this.createdAt = createdAt;
        this.transactionType = transactionType;
    }
}
