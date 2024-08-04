package com.example.demo.account.entity;

import com.example.demo.transaction.entity.Transaction;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@DiscriminatorValue("deposit")
public class AccountDeposit extends Account {
    public AccountDeposit(String accountId, AccountType accountType, String clientID, double balance, boolean withdrawAllowed, List<Transaction> transactions) {
        super(accountId, accountType, clientID, balance, withdrawAllowed, transactions);
    }
}
