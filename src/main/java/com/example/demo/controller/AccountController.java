package com.example.demo.controller;

import com.example.demo.entity.account.Account;
import com.example.demo.entity.account.AccountDTO;
import com.example.demo.service.AccountCreationService;
import com.example.demo.service.AccountListingService;
import com.example.demo.entity.transaction.Transaction;
import com.example.demo.service.AccountDepositService;
import com.example.demo.service.AccountWithdrawService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountController {

    private AccountListingService accountListingService;
    private AccountCreationService accountCreationService;
    private AccountDepositService accountDepositService;
    private AccountWithdrawService accountWithdrawService;


    @GetMapping
    public ResponseEntity<List<Account>> getAccounts(){
        List<Account> accounts = accountListingService.getAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody @Valid AccountDTO account){
        Account newAcc = accountCreationService.create(account);
        return new ResponseEntity<>(newAcc, HttpStatus.CREATED);
    }

    @GetMapping("/{account_id}")
    public ResponseEntity<Account> getAccount(@PathVariable String account_id){
        Account account = accountListingService.getAccount(account_id);

        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @DeleteMapping("/{account_id}")
    public ResponseEntity<String> deleteAccount(@PathVariable String account_id){
        accountListingService.deleteAccount(account_id);
        String message = "account " + account_id + " deleted";

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("/{account_id}/withdraw")
    public ResponseEntity<Transaction> withdrawMoney(@PathVariable String account_id, @RequestParam("amount") Double amount){
        Transaction transaction = accountWithdrawService.withdraw(amount,account_id);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @PostMapping("/{account_id}/deposit")
    public ResponseEntity<Transaction> depositMoney(@PathVariable String account_id, @RequestParam("amount") Double amount){
        Transaction transaction = accountDepositService.deposit(amount,account_id);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @GetMapping("/{account_id}/transactions")
    public ResponseEntity<List<Transaction>> getTransactions(@PathVariable String account_id){
        Account account = accountListingService.getAccount(account_id);
        List<Transaction> transactions = account.getTransactions();

        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

}
























