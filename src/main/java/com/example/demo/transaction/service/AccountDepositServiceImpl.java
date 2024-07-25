package com.example.demo.transaction.service;

import com.example.demo.account.dao.AccountDaoRepository;
import com.example.demo.account.domen.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountDepositServiceImpl implements AccountDepositService{
    private AccountDaoRepository accountDaoRepository;

    @Override
    public void deposit(double amount, Account account) {
        double newAmount = account.getBalance() + amount;
        account.setBalance(newAmount);
        accountDaoRepository.save(account);
    }
}
