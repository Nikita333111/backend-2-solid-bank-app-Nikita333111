package com.example.demo.service;

import com.example.demo.entity.account.Account;
import com.example.demo.entity.account.AccountDTO;
import com.example.demo.AccountType;

public interface AccountCreationService {
    void create(AccountType accountType, long bankID, String clientID, long accountId);
    Account create(AccountDTO account);
}
