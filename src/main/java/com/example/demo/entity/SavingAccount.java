package com.example.demo.entity;

public class SavingAccount extends AccountWithdraw{
    public SavingAccount(AccountType accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientID, balance, withdrawAllowed);
    }
}
