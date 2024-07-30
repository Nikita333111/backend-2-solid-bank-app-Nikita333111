package com.example.demo.service;

import com.example.demo.entity.account.AccountWithdraw;
import com.example.demo.entity.transaction.Transaction;
import org.springframework.stereotype.Service;

@Service
public interface AccountWithdrawService {
    void withdraw(double amount, AccountWithdraw account);

    Transaction withdraw(double amount, String account_id);
}
