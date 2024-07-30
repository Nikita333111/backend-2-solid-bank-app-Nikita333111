package com.example.demo.service.impl;

import com.example.demo.dao.AccountDaoRepository;
import com.example.demo.AccountType;
import com.example.demo.entity.account.Account;
import com.example.demo.entity.account.AccountDTO;
import com.example.demo.service.AccountCreationService;
import org.springframework.stereotype.Service;

@Service
public class AccountCreationServiceImpl implements AccountCreationService {
    private AccountDaoRepository accountDaoRepository;
    public static final double START_BALANCE = 0.0;
    private long lastAccountNumber = 1;

    public AccountCreationServiceImpl(AccountDaoRepository accountDaoRepository){
        this.accountDaoRepository = accountDaoRepository;
    }

    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountId) {
        boolean withdraw = !accountType.name().equals("FIXED");
        String accountNumber = String.format("%03d%06d", 1, accountId);

        Account account = Account.builder()
                .accountType(accountType)
                .accountId(accountNumber)
                .balance(START_BALANCE)
                .clientID(clientID)
                .withdrawAllowed(withdraw)
                .build();

        accountDaoRepository.save(account);
    }

    @Override
    public Account create(AccountDTO accountDTO) {
        AccountType accountType = AccountType.valueOf(accountDTO.getAccountType().name());

        boolean withdraw = !accountType.equals(AccountType.FIXED);
        String accountNumber = String.format("%03d%06d", 1, lastAccountNumber);
        incrementLastAccountNumber();

        Account account = Account.builder()
                .accountId(accountNumber)
                .accountType(accountDTO.getAccountType())
                .balance(START_BALANCE)
                .withdrawAllowed(withdraw)
                .clientID("1")
                .build();
        return accountDaoRepository.save(account);
    }

    private void incrementLastAccountNumber(){
        this.lastAccountNumber = this.lastAccountNumber + 1;
    }
}
