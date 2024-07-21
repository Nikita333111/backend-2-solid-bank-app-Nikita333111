package com.example.demo.transaction.service;

import com.example.demo.account.domen.Account;
import com.example.demo.account.domen.AccountWithdraw;

public interface AccountDepositService {
    void deposit(double amount, Account account);
}
