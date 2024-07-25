package com.example.demo.transaction.domen;

import com.example.demo.account.domen.Account;
import com.example.demo.transaction.dao.TransactionDaoRepository;
import com.example.demo.transaction.service.AccountDepositService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@AllArgsConstructor
public class TransactionDeposit {
    private AccountDepositService accountDepositService;
    private TransactionDaoRepository transactionDaoRepository;

    public void execute(Account account, double amount){
        accountDepositService.deposit(amount,account);
        transactionDaoRepository.save(new Transaction(account.getAccountId(),amount,account.getClientID(), new Date()));
    }
}
