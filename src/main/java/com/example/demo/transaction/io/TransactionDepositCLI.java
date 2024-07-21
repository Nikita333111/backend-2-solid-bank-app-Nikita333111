package com.example.demo.transaction.io;

import com.example.demo.account.domen.Account;
import com.example.demo.account.domen.AccountDeposit;
import com.example.demo.account.domen.AccountWithdraw;
import com.example.demo.account.service.AccountListingService;
import com.example.demo.transaction.domen.TransactionDeposit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;

@Component
@AllArgsConstructor
public class TransactionDepositCLI {
    private TransactionDeposit transactionDeposit;
    private WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    private AccountListingService accountListing;


    public void depositMoney(String clientID) {
        String accountID = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        if (amount <= 0) {
            throw new IllegalArgumentException("amount of money must be positive");
        }
        Account account = accountListing.getClientAccount(clientID, accountID);

        transactionDeposit.execute(account, amount);

        System.out.println(amount + "$ transferred to " + accountID + " account");
    }

}
