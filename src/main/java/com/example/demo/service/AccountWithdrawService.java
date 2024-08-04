package com.example.demo.service;

import com.example.demo.account.entity.AccountWithdraw;
import com.example.demo.transaction.entity.Transaction;
import org.springframework.stereotype.Service;

@Service
public interface AccountWithdrawService {
    void withdraw(double amount, AccountWithdraw account);

    Transaction withdraw(double amount, String account_id);
}
