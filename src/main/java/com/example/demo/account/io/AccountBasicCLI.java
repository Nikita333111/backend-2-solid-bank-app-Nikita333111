package com.example.demo.account.io;

import com.example.demo.account.domen.BankCore;
import com.example.demo.account.service.AccountListingService;
import com.example.demo.account.service.CreateAccountOperationUI;
import com.example.demo.account.util.AccountType;
import org.springframework.stereotype.Component;

@Component
public class AccountBasicCLI {
    private CreateAccountOperationUI createAccountOperationUI;
    private BankCore bankCore;
    private AccountListingService accountListingService;

    public AccountBasicCLI(CreateAccountOperationUI createAccountOperationUI, BankCore bankCore, AccountListingService accountListingService){
        this.createAccountOperationUI = createAccountOperationUI;
        this.bankCore = bankCore;
        this.accountListingService = accountListingService;
    }

    public void createAccountRequest(String clientID) throws IllegalArgumentException{
        AccountType accountType = createAccountOperationUI.requestAccountType();
        bankCore.createNewAccount(accountType,clientID);
    }

    public void getAccounts(String clientID){
        System.out.println(accountListingService.getClientAccounts(clientID));
    }
}



















