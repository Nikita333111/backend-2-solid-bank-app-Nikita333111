package com.example.demo.account.domen;

import com.example.demo.account.util.AccountType;

// можно снимать и вносить деньги
public class AccountWithdraw extends Account{
    public AccountWithdraw(AccountType accountType, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, clientID, balance, withdrawAllowed);
    }
}
