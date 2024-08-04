package com.example.demo.service;

import com.example.demo.account.entity.Account;
import com.example.demo.account.entity.AccountDTO;
import com.example.demo.account.entity.AccountType;

public interface AccountCreationService {
    void create(AccountType accountType, long bankID, String clientID, long accountId);
    Account create(AccountDTO account);
}
