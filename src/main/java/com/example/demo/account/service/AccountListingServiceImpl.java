package com.example.demo.account.service;

import com.example.demo.account.dao.AccountDAO;
import com.example.demo.account.domen.Account;
import com.example.demo.account.domen.AccountWithdraw;
import com.example.demo.account.util.AccountType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountListingServiceImpl implements AccountListingService {
    private AccountDAO accountDAO;

    AccountListingServiceImpl(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        return accountDAO.getClientAccount(clientID,accountID);
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        return accountDAO.getClientWithdrawAccount(clientID, accountID);
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return accountDAO.getClientAccounts(clientID);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return accountDAO.getClientAccountsByType(clientID, accountType);
    }
}
