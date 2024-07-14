package com.example.demo.service;

import com.example.demo.entity.AccountType;

public interface AccountCreationService {
    void create(AccountType accountType, long bankID, String clientID, long accountID);
}
