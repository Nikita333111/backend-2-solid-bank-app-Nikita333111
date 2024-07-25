package com.example.demo.account.service;

import com.example.demo.account.util.AccountType;

public interface AccountCreationService {
    void create(AccountType accountType, long bankID, String clientID);
}
