package com.example.demo.transaction.domen;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private @Id Long transactionId;
    private Long accountId;
    private double amount;
    private String clientID;
    private Date createdAt;

    public Transaction(Long accountID, double amount, String clientID, Date createdAt) {
        this.accountId = accountID;
        this.amount = amount;
        this.clientID = clientID;
        this.createdAt = createdAt;
    }
}
