package com.example.demo.dao;

import com.example.demo.entity.Account;
import com.example.demo.entity.AccountType;
import com.example.demo.entity.AccountWithdraw;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryAccountDAO implements AccountDAO{
    private List<Account> accountList;

    public MemoryAccountDAO(){
        accountList = new ArrayList<>();
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        List<Account> clientAccounts = new ArrayList<>();
        for (Account account : accountList){
            if (account.getClientID().equals(clientID))
                clientAccounts.add(account);
        }
        return clientAccounts;
    }

    @Override
    public void createNewAccount(Account account) {
        accountList.add(account);
    }

    @Override
    public void updateAccount(Account account) {
        Optional<Account> accountOptional = accountList.stream()
                .filter(a -> a.getId().equals(account.getId()))
                .findFirst();

        accountOptional.ifPresent(account1 -> {
            int index = accountList.indexOf(account1);
            accountList.set(index, account);
            System.out.println("account updated");
        });
        if (accountOptional.isEmpty())
            System.out.println("such account doesnt exist");
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return accountList.stream().filter(account -> account.getClientID().equals(clientID) && account.getAccountType() == accountType).collect(Collectors.toList());
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        for (Account account : accountList){
            if (account.getClientID().equals(clientID) && account.getId().equals(accountID))
                return (AccountWithdraw) account;
        }
        System.out.println("can't find an account");
        return null;
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        for (Account account : accountList){
            if (account.getClientID().equals(clientID) && account.getId().equals(accountID))
                return account;
        }
        System.out.println("can't find an account");
        return null;
    }
}
