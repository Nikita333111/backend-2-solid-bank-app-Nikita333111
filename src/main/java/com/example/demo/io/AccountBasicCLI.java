package com.example.demo.io;

import com.example.demo.entity.AccountType;
import com.example.demo.entity.BankCore;
import com.example.demo.service.AccountListingService;
import com.example.demo.service.CreateAccountOperationUI;

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
        accountListingService.getClientAccounts(clientID).forEach(System.out::println);
    }
}



















