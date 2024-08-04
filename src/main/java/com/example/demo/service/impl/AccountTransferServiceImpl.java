package com.example.demo.service.impl;

import com.example.demo.account.dao.AccountDaoRepository;
import com.example.demo.account.entity.Account;
import com.example.demo.client.entity.Client;
import com.example.demo.exceptions.AccountNotFound;
import com.example.demo.exceptions.InvalidAmount;
import com.example.demo.service.AccountTransferService;
import com.example.demo.transaction.dao.TransactionDaoRepository;
import com.example.demo.transaction.entity.Transaction;
import com.example.demo.transaction.entity.TransactionType;
import com.example.demo.transaction.entity.TransferTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AccountTransferServiceImpl implements AccountTransferService {

    private final AccountDaoRepository accountRepository;
    private final TransactionDaoRepository transactionRepository;

    @Override
    public Transaction transfer(String accountId, TransferTransaction transferTransaction) {
        Long clientID = ((Client) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getClientId();
        String clientId = String.valueOf(clientID);
        double amount = transferTransaction.getAmount();
        String destAccountId = transferTransaction.getDestination_account_id();

        Account accountFrom = accountRepository.findAccountByClientIDAndAccountId(clientId, accountId).orElseThrow(() -> new AccountNotFound("account not found"));
        Account accountTo = accountRepository.findById(destAccountId).orElseThrow(() -> new AccountNotFound("destination account not found"));

        if(accountFrom.getBalance() < amount ||
                amount < 0 ||
                accountId.equals(destAccountId) ||
                !accountFrom.isWithdrawAllowed())
            throw new InvalidAmount("wrong amount or account is not withdraw");


        Transaction transaction = Transaction.builder()
                .accountId(accountId)
                .amount(amount)
                .clientID(clientId)
                .createdAt(new Date())
                .transactionType(TransactionType.TRANSFER)
                .build();

        transactionRepository.save(transaction);

        double newBalance = accountFrom.getBalance() - amount;
        accountFrom.setBalance(newBalance);
        accountFrom.addTransaction(transaction);
        accountRepository.save(accountFrom);

        double newBalance1 = accountTo.getBalance() + amount;
        accountTo.setBalance(newBalance1);
        accountRepository.save(accountTo);


        return transaction;
    }
}
