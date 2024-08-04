package com.example.demo.controller;

import com.example.demo.account.entity.Account;
import com.example.demo.account.entity.AccountDTO;
import com.example.demo.service.*;
import com.example.demo.transaction.entity.Transaction;
import com.example.demo.transaction.entity.TransferTransaction;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
    private AccountTransferService accountTransferService;


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

    @PostMapping("/{account_id}/transfer")
    public ResponseEntity<Transaction> transfer(@PathVariable String account_id,
                                                @RequestBody TransferTransaction transferTransaction){
        Transaction transaction = accountTransferService.transfer(account_id, transferTransaction);

        return ResponseEntity.ok(transaction);
    }

}
























