package com.example.demo.account.service;

import com.example.demo.account.dao.AccountDaoRepository;
import com.example.demo.account.domen.Account;
import com.example.demo.account.domen.CheckingAccount;
import com.example.demo.account.domen.FixedAccount;
import com.example.demo.account.domen.SavingAccount;
import com.example.demo.account.util.AccountType;
import org.springframework.stereotype.Service;

@Service
public class AccountCreationServiceImpl implements AccountCreationService{
    private AccountDaoRepository accountDaoRepository;
    public static final double START_BALANCE = 0.0;

    public AccountCreationServiceImpl(AccountDaoRepository accountDaoRepository){
        this.accountDaoRepository = accountDaoRepository;
    }

    @Override
    public void create(AccountType accountType, long bankID, String clientID) {
        boolean withdraw = !accountType.name().equals("FIXED");
        if (accountType == AccountType.CHECKING) {
            accountDaoRepository.save(new Account(accountType, clientID, START_BALANCE, withdraw));
        } else if (accountType == AccountType.SAVING) {
            accountDaoRepository.save(new Account(accountType, clientID, START_BALANCE, withdraw));
        } else {
            accountDaoRepository.save(new Account(accountType, clientID, START_BALANCE, withdraw));
        }
    }
}
