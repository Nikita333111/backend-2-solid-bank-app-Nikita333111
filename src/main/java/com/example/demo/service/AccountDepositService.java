package com.example.demo.service;

import com.example.demo.account.entity.Account;
import com.example.demo.transaction.entity.Transaction;

public interface AccountDepositService {
    void deposit(double amount, Account account);

    Transaction deposit(double amount, String account_id);
}
