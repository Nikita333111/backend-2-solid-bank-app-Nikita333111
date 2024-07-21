package com.example.demo.transaction.service;

import com.example.demo.account.domen.AccountWithdraw;
import org.springframework.stereotype.Service;

@Service
public interface AccountWithdrawService {
    void withdraw(double amount, AccountWithdraw account);
}
