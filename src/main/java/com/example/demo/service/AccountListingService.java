package com.example.demo.service;

import com.example.demo.entity.account.Account;
import com.example.demo.entity.account.AccountWithdraw;
import com.example.demo.AccountType;

import java.util.List;

public interface AccountListingService {
    Account getClientAccount(String clientID, String accountID);

    AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);

    List<Account> getClientAccounts(String clientID);

    List<Account> getClientAccountsByType(String clientID, AccountType accountType);

    List<Account> getAccounts();

    Account getAccount(String accountId);

    void deleteAccount(String accountId);
}
