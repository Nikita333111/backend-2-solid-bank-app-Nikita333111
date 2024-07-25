package com.example.demo.account.service;

import com.example.demo.account.dao.AccountDaoRepository;
import com.example.demo.account.domen.Account;
import com.example.demo.account.domen.AccountWithdraw;
import com.example.demo.account.util.AccountType;
import org.springframework.stereotype.Service;

import java.util.IllegalFormatCodePointException;
import java.util.List;

@Service
public class AccountListingServiceImpl implements AccountListingService {
    private AccountDaoRepository accountDaoRepository;

    AccountListingServiceImpl(AccountDaoRepository accountDaoRepository){
        this.accountDaoRepository = accountDaoRepository;
    }

    @Override
    public Account getClientAccount(String clientID, Long accountID) {
        return accountDaoRepository.getAccountsByClientIDAndAccountId(clientID,accountID);
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, Long accountID) {
        Account account = accountDaoRepository.getAccountsByClientIDAndAccountId(clientID, accountID);
        AccountWithdraw accountWithdraw = null;
        if (account != null && account.isWithdrawAllowed()) {
            accountWithdraw = new AccountWithdraw(account.getAccountType(), account.getClientID(), account.getBalance(), true);
            accountWithdraw.setAccountId(account.getAccountId());
            accountWithdraw.setTransactions(account.getTransactions());
        }

        return accountWithdraw;
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return accountDaoRepository.findAccountsByClientID(clientID);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return accountDaoRepository.getAccountsByClientIDAndAccountType(clientID, accountType);
    }
}
