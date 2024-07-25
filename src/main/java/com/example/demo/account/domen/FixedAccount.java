package com.example.demo.account.domen;

import com.example.demo.account.util.AccountType;

public class FixedAccount extends AccountDeposit{
    public FixedAccount(AccountType accountType, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, clientID, balance, withdrawAllowed);
    }
}
