package com.example.demo.account.domen;

import com.example.demo.account.util.AccountType;
import com.example.demo.transaction.domen.Transaction;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private @Id Long accountId;
    private AccountType accountType;
    private String clientID;
    private double balance;
    private boolean withdrawAllowed;

    @MappedCollection(keyColumn = "ACCOUNT_ID", idColumn = "ACCOUNT_ID")
    Set<Transaction> transactions;

    public Account( AccountType accountType, String clientID, double balance, boolean withdrawAllowed) {
        this.accountType = accountType;
        this.clientID = clientID;
        this.balance = balance;
        this.withdrawAllowed = withdrawAllowed;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + String.format("%03d%06d", 1, accountId) +
                ", accountType=" + accountType +
                ", clientID='" + clientID + '\'' +
                ", balance=" + balance +
                ", withdrawAllowed=" + withdrawAllowed +
                ", transactions=" + transactions +
                '}';
    }
}
