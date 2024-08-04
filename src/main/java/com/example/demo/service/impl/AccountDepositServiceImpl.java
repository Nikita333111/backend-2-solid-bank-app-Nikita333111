package com.example.demo.service.impl;

import com.example.demo.account.dao.AccountDaoRepository;
import com.example.demo.account.entity.Account;
import com.example.demo.client.entity.Client;
import com.example.demo.exceptions.AccountNotFound;
import com.example.demo.exceptions.InvalidAmount;
import com.example.demo.transaction.dao.TransactionDaoRepository;
import com.example.demo.transaction.entity.Transaction;
import com.example.demo.transaction.entity.TransactionType;
import com.example.demo.service.AccountDepositService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class AccountDepositServiceImpl implements AccountDepositService {
    private AccountDaoRepository accountDaoRepository;
    private TransactionDaoRepository transactionDaoRepository;

    @Override
    public void deposit(double amount, Account account) {
        double newAmount = account.getBalance() + amount;
        account.setBalance(newAmount);
        accountDaoRepository.save(account);
    }

    @Override
    public Transaction deposit(double amount, String account_id) {
        Long clientID = ((Client) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getClientId();
        String clientId = String.valueOf(clientID);
        Account account = accountDaoRepository.findAccountByClientIDAndAccountId(clientId, account_id).orElseThrow(() -> new AccountNotFound(account_id));
        if (amount <= 0) throw new InvalidAmount(String.valueOf(amount));

        Transaction transaction = Transaction.builder()
                .accountId(account.getAccountId())
                .amount(amount)
                .clientID(clientId)
                .createdAt(new Date())
                .transactionType(TransactionType.DEPOSIT)
                .build();
        transactionDaoRepository.save(transaction);

        double newAmount = account.getBalance() + amount;
        account.setBalance(newAmount);
        account.addTransaction(transaction);
        accountDaoRepository.save(account);

        return transaction;
    }
}
