package com.example.demo.exceptions;

public class AccountNotFound extends RuntimeException {
    public AccountNotFound(String id){
        super(String.format("Could not find account %s", id));
    }
}
