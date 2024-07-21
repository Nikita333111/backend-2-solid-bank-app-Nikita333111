package com.example.demo.transaction.domen;

import com.example.demo.account.domen.Account;
import com.example.demo.account.domen.AccountDeposit;
import com.example.demo.account.domen.AccountWithdraw;
import com.example.demo.transaction.dao.TransactionDAO;
import com.example.demo.transaction.service.AccountDepositService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@AllArgsConstructor
public class TransactionDeposit {
    private AccountDepositService accountDepositService;
    private TransactionDAO transactionDAO;

    public void execute(Account account, double amount){
        accountDepositService.deposit(amount,account);
        transactionDAO.addTransaction(new Transaction(account.getId(),amount,account.getClientID(), new Date()));
    }
}
