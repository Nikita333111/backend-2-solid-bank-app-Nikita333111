package com.example.demo.service;

import com.example.demo.dao.AccountDAO;
import com.example.demo.entity.*;

public class AccountCreationServiceImpl implements AccountCreationService{
    private AccountDAO accountDAO;
    public static final double START_BALANCE = 0.0;

    public AccountCreationServiceImpl(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID) {
        boolean withdraw = !accountType.name().equals("FIXED");
        if (accountType == AccountType.CHECKING) {
            accountDAO.createNewAccount(new CheckingAccount(accountType, accountID + "", clientID, START_BALANCE, withdraw));
        } else if (accountType == AccountType.SAVING) {
            accountDAO.createNewAccount(new SavingAccount(accountType, accountID + "", clientID, START_BALANCE, withdraw));
        } else {
            accountDAO.createNewAccount(new FixedAccount(accountType, accountID + "", clientID, START_BALANCE, withdraw));
        }
    }
}
