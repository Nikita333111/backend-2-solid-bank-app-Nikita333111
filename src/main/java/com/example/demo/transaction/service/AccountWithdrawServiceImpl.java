package com.example.demo.transaction.service;

import com.example.demo.account.dao.AccountDaoRepository;
import com.example.demo.account.domen.Account;
import com.example.demo.account.domen.AccountWithdraw;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    AccountDaoRepository accountDaoRepository;
    @Override
    public void withdraw(double amount, AccountWithdraw account) {
        double newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);
        Account account1 = new Account(account.getAccountType(),account.getClientID(),account.getBalance(),account.isWithdrawAllowed());
        account1.setAccountId(account.getAccountId());
        account1.setTransactions(account.getTransactions());
        accountDaoRepository.save(account1);
    }

}
