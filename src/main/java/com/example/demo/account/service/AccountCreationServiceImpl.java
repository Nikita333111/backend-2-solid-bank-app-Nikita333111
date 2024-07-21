package com.example.demo.account.service;

import com.example.demo.account.dao.AccountDAO;
import com.example.demo.account.domen.CheckingAccount;
import com.example.demo.account.domen.FixedAccount;
import com.example.demo.account.domen.SavingAccount;
import com.example.demo.account.util.AccountType;
import org.springframework.stereotype.Service;

@Service
public class AccountCreationServiceImpl implements AccountCreationService{
    private AccountDAO accountDAO;
    public static final double START_BALANCE = 0.0;

    public AccountCreationServiceImpl(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID) {
        String accountNumber = String.format("%03d%06d", 1, accountID);

        boolean withdraw = !accountType.name().equals("FIXED");
        if (accountType == AccountType.CHECKING) {
            accountDAO.createNewAccount(new CheckingAccount(accountType, accountNumber, clientID, START_BALANCE, withdraw));
        } else if (accountType == AccountType.SAVING) {
            accountDAO.createNewAccount(new SavingAccount(accountType, accountNumber, clientID, START_BALANCE, withdraw));
        } else {
            accountDAO.createNewAccount(new FixedAccount(accountType, accountNumber, clientID, START_BALANCE, withdraw));
        }
    }
}
