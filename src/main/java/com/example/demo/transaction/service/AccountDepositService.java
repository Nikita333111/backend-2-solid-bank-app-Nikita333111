package com.example.demo.transaction.service;

import com.example.demo.account.domen.Account;

public interface AccountDepositService {
    void deposit(double amount, Account account);
}
