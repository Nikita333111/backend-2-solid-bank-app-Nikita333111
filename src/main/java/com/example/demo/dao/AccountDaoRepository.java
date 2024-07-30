package com.example.demo.dao;

import com.example.demo.entity.account.Account;
import com.example.demo.AccountType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountDaoRepository extends CrudRepository<Account, String> {

    List<Account> findAccountsByClientID(String clientID);

    List<Account> getAccountsByClientIDAndAccountType(String clientID, AccountType accountType);

    Account getAccountsByClientIDAndAccountId(String clientID, String accountId);

}
