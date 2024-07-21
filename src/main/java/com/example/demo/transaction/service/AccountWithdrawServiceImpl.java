package com.example.demo.transaction.service;

import com.example.demo.account.dao.AccountDAO;
import com.example.demo.account.domen.AccountWithdraw;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    AccountDAO accountDAO;
    @Override
    public void withdraw(double amount, AccountWithdraw account) {
        double newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);
        accountDAO.updateAccount(account);
    }

}
