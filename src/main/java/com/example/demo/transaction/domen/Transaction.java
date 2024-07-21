package com.example.demo.transaction.domen;

import com.example.demo.account.domen.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@AllArgsConstructor
public class Transaction {
    private String accountID;
    private double amount;
    private String clientID;
    private Date createdAt;
}
