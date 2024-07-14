package com.example.demo.dao;

import com.example.demo.entity.Account;
import com.example.demo.entity.AccountType;
import com.example.demo.entity.AccountWithdraw;

import java.util.List;

public interface AccountDAO {

    List<Account> getClientAccounts(String clientID);

    void createNewAccount(Account account);

    void updateAccount(Account account);

    List<Account> getClientAccountsByType(String clientID, AccountType accountType);

    AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);

    Account getClientAccount(String clientID, String accountID);

}
