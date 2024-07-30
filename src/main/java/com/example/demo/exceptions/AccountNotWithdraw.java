package com.example.demo.exceptions;

public class AccountNotWithdraw extends RuntimeException{
    public AccountNotWithdraw(String account_id){
        super(account_id + " account is not withdraw");
    }
}
