package com.example.demo.transaction.domen;

import com.example.demo.account.domen.AccountWithdraw;
import com.example.demo.transaction.dao.TransactionDAO;
import com.example.demo.transaction.service.AccountWithdrawService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@AllArgsConstructor
public class TransactionWithdraw {
    private AccountWithdrawService accountWithdrawService;
    private TransactionDAO transactionDAO;

    public void execute(AccountWithdraw accountWithdraw, AccountWithdraw accountWithdraw2, double amount){
        accountWithdrawService.withdraw(amount, accountWithdraw);
        transactionDAO.addTransaction(new Transaction(accountWithdraw.getId(), amount, accountWithdraw.getClientID(), new Date()));
    }
}
