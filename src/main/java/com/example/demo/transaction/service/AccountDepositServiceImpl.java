package com.example.demo.transaction.service;

import com.example.demo.account.dao.AccountDAO;
import com.example.demo.account.domen.Account;
import com.example.demo.account.domen.AccountWithdraw;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountDepositServiceImpl implements AccountDepositService{
    private AccountDAO accountDAO;

    @Override
    public void deposit(double amount, Account account) {
        double newAmount = account.getBalance() + amount;
        account.setBalance(newAmount);
        accountDAO.updateAccount(account);
    }
}
