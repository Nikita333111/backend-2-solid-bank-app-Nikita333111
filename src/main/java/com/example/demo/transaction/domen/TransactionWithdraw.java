package com.example.demo.transaction.domen;

import com.example.demo.account.domen.AccountWithdraw;
import com.example.demo.transaction.dao.TransactionDaoRepository;
import com.example.demo.transaction.service.AccountWithdrawService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@AllArgsConstructor
public class TransactionWithdraw {
    private AccountWithdrawService accountWithdrawService;
    private TransactionDaoRepository transactionDaoRepository;

    public void execute(AccountWithdraw accountWithdraw, AccountWithdraw accountWithdraw2, double amount){
        accountWithdrawService.withdraw(amount, accountWithdraw);
        transactionDaoRepository.save(new Transaction(accountWithdraw.getAccountId(), amount, accountWithdraw.getClientID(), new Date()));
    }
}
