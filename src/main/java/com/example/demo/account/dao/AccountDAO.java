package com.example.demo.account.dao;

import com.example.demo.account.domen.Account;
import com.example.demo.account.util.AccountType;
import com.example.demo.account.domen.AccountWithdraw;

import java.util.List;

public interface AccountDAO {

    List<Account> getClientAccounts(String clientID);

    void createNewAccount(Account account);

    void updateAccount(Account account);

    List<Account> getClientAccountsByType(String clientID, AccountType accountType);

    AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);

    Account getClientAccount(String clientID, String accountID);

}
