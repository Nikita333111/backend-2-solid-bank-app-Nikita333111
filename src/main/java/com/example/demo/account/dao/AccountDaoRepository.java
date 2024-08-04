package com.example.demo.account.dao;

import com.example.demo.account.entity.Account;
import com.example.demo.account.entity.AccountType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AccountDaoRepository extends CrudRepository<Account, String> {

    List<Account> findAccountsByClientID(String clientID);

    List<Account> getAccountsByClientIDAndAccountType(String clientID, AccountType accountType);

    Account getAccountsByClientIDAndAccountId(String clientID, String accountId);

    Optional<Account> findAccountByClientIDAndAccountId(String clientID, String accountId);

}
