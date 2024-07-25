package com.example.demo.account.domen;

import com.example.demo.account.util.AccountType;

public class SavingAccount extends AccountWithdraw{
    public SavingAccount(AccountType accountType, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, clientID, balance, withdrawAllowed);
    }
}
