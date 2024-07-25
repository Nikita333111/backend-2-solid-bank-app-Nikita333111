package com.example.demo.transaction.io;

import com.example.demo.account.domen.Account;
import com.example.demo.account.service.AccountListingService;
import com.example.demo.transaction.domen.TransactionDeposit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

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
        long accountId = Long.parseLong(accountID.substring(3));
        Account account = accountListing.getClientAccount(clientID, accountId);

        transactionDeposit.execute(account, amount);

        System.out.println(amount + "$ transferred to " + accountID + " account");
    }

}
