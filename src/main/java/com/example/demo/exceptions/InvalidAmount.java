package com.example.demo.exceptions;

public class InvalidAmount extends RuntimeException{
    public InvalidAmount(String amount){
        super(amount + " incorrect amount");
    }
}
