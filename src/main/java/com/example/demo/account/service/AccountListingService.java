package com.example.demo.account.service;

import com.example.demo.account.domen.Account;
import com.example.demo.account.domen.AccountWithdraw;
import com.example.demo.account.util.AccountType;

import java.util.List;

public interface AccountListingService {
    Account getClientAccount(String clientID, Long accountID);

    AccountWithdraw getClientWithdrawAccount(String clientID, Long accountID);

    List<Account> getClientAccounts(String clientID);

    List<Account> getClientAccountsByType(String clientID, AccountType accountType);
}
