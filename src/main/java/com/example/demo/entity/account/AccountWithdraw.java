package com.example.demo.entity.account;

import com.example.demo.AccountType;
import com.example.demo.entity.transaction.Transaction;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@DiscriminatorValue("withdraw")
public class AccountWithdraw extends Account{
    public AccountWithdraw(String accountId, AccountType accountType, String clientID, double balance, boolean withdrawAllowed, List<Transaction> transactions) {
        super(accountId, accountType, clientID, balance, withdrawAllowed, transactions);
    }
}
