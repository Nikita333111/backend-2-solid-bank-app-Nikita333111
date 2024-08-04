package com.example.demo.account.entity;

import com.example.demo.transaction.entity.Transaction;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@DiscriminatorValue("checking")
@NoArgsConstructor
public class CheckingAccount extends AccountWithdraw{

    public CheckingAccount(String accountId, AccountType accountType, String clientID, double balance, boolean withdrawAllowed, List<Transaction> transactions) {
        super(accountId, accountType, clientID, balance, withdrawAllowed, transactions);
    }
}
