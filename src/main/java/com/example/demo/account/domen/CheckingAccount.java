package com.example.demo.account.domen;

import com.example.demo.account.util.AccountType;

public class CheckingAccount extends AccountWithdraw{
    public CheckingAccount(AccountType accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientID, balance, withdrawAllowed);
    }
}
