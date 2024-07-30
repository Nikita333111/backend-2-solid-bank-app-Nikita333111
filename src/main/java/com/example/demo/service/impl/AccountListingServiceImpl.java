package com.example.demo.service.impl;

import com.example.demo.dao.AccountDaoRepository;
import com.example.demo.entity.account.Account;
import com.example.demo.entity.account.AccountWithdraw;
import com.example.demo.AccountType;
import com.example.demo.exceptions.AccountNotFound;
import com.example.demo.service.AccountListingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountListingServiceImpl implements AccountListingService {
    private AccountDaoRepository accountDaoRepository;

    AccountListingServiceImpl(AccountDaoRepository accountDaoRepository){
        this.accountDaoRepository = accountDaoRepository;
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        return accountDaoRepository.getAccountsByClientIDAndAccountId(clientID,accountID);
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        AccountWithdraw account = (AccountWithdraw) accountDaoRepository.getAccountsByClientIDAndAccountId(clientID, accountID);
        if (account != null && account.isWithdrawAllowed())
            return account;

        return null;
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return accountDaoRepository.findAccountsByClientID(clientID);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return accountDaoRepository.getAccountsByClientIDAndAccountType(clientID, accountType);
    }

    @Override
    public List<Account> getAccounts() {
        return (List<Account>) accountDaoRepository.findAll();
    }

    @Override
    public Account getAccount(String accountId) {
        return accountDaoRepository.findById(accountId).orElseThrow(() -> new AccountNotFound(accountId));
    }

    @Override
    public void deleteAccount(String accountId) {
        accountDaoRepository.findById(accountId).orElseThrow(() -> new AccountNotFound(accountId));
        accountDaoRepository.deleteById(accountId);
    }
}
