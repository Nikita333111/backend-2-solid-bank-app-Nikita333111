package com.example.demo.account.service;

import com.example.demo.account.domen.Account;
import com.example.demo.account.domen.AccountWithdraw;
import com.example.demo.account.util.AccountType;

import java.util.List;

public interface AccountListingService {
    Account getClientAccount(String clientID, String accountID);

    AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);

    List<Account> getClientAccounts(String clientID);

    List<Account> getClientAccountsByType(String clientID, AccountType accountType);
}
