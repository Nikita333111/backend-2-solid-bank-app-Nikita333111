package com.example.demo.service;

import com.example.demo.entity.account.Account;
import com.example.demo.entity.transaction.Transaction;

public interface AccountDepositService {
    void deposit(double amount, Account account);

    Transaction deposit(double amount, String account_id);
}
