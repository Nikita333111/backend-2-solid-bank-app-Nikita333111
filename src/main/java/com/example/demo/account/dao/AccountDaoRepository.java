package com.example.demo.account.dao;

import com.example.demo.account.domen.Account;
import com.example.demo.account.domen.AccountWithdraw;
import com.example.demo.account.util.AccountType;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountDaoRepository extends CrudRepository<Account, Long> {

    List<Account> findAccountsByClientID(String clientID);

    List<Account> getAccountsByClientIDAndAccountType(String clientID, AccountType accountType);

    Account getAccountsByClientIDAndAccountId(String clientID, Long accountId);

}
