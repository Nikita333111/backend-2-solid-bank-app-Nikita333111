package com.example.demo.account.domen;

import com.example.demo.account.util.AccountType;

// только снимать
public class AccountDeposit extends Account{
    public AccountDeposit(AccountType accountType,String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, clientID, balance, withdrawAllowed);
    }
}
