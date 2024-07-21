package com.example.demo.transaction.io;

import com.example.demo.account.domen.AccountWithdraw;
import com.example.demo.account.service.AccountListingService;
import com.example.demo.transaction.domen.TransactionWithdraw;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionWithdrawCLI {
    private TransactionWithdraw transactionWithdraw;
    private WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListing;

    public void withdrawMoney(String clientID){
        String accountID = withdrawDepositOperationCLIUI.requestClientAccountNumber();

        AccountWithdraw accountWithdraw = accountListing.getClientWithdrawAccount(clientID, accountID);
        if(accountWithdraw == null)
            throw new IllegalArgumentException("Account with such id is not withdraw or doesnt exist");

        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        if (amount <= 0 || amount > accountWithdraw.getBalance())
            throw new IllegalArgumentException("incorrect amount for withdraw");

        transactionWithdraw.execute(accountWithdraw,accountWithdraw, amount);
        System.out.println(amount + "$ transferred from " + accountID + " account");
    }
}



















