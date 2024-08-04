package com.example.demo.service.impl;

import com.example.demo.account.dao.AccountDaoRepository;
import com.example.demo.account.entity.Account;
import com.example.demo.account.entity.AccountWithdraw;
import com.example.demo.client.entity.Client;
import com.example.demo.exceptions.AccountNotFound;
import com.example.demo.exceptions.AccountNotWithdraw;
import com.example.demo.exceptions.InvalidAmount;
import com.example.demo.transaction.dao.TransactionDaoRepository;
import com.example.demo.transaction.entity.Transaction;
import com.example.demo.transaction.entity.TransactionType;
import com.example.demo.service.AccountWithdrawService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    private AccountDaoRepository accountDaoRepository;
    private TransactionDaoRepository transactionDaoRepository;
    @Override
    public void withdraw(double amount, AccountWithdraw account) {
        double newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);

        accountDaoRepository.save(account);
    }

    @Override
    public Transaction withdraw(double amount, String account_id) {
        Long clientID = ((Client) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getClientId();
        String clientId = String.valueOf(clientID);
        Account account = accountDaoRepository.findAccountByClientIDAndAccountId(clientId, account_id).orElseThrow(() -> new AccountNotFound(account_id));
        if (!account.isWithdrawAllowed()) throw new AccountNotWithdraw(account_id);
        if (amount <= 0 || amount > account.getBalance()) throw new InvalidAmount(String.valueOf(amount));

        Transaction transaction = Transaction.builder()
                .accountId(account.getAccountId())
                .amount(amount)
                .clientID(clientId)
                .createdAt(new Date())
                .transactionType(TransactionType.WITHDRAW)
                .build();
        transactionDaoRepository.save(transaction);

        double newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);
        account.addTransaction(transaction);
        accountDaoRepository.save(account);

        return transaction;

    }

}
