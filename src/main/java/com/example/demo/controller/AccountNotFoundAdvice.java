package com.example.demo.controller;

import com.example.demo.exceptions.AccountNotFound;
import com.example.demo.exceptions.AccountNotWithdraw;
import com.example.demo.exceptions.EmailAlreadyExist;
import com.example.demo.exceptions.InvalidAmount;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AccountNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler({AccountNotFound.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String accountNotFound(AccountNotFound ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler({AccountNotWithdraw.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String accountNotWithdraw(AccountNotWithdraw ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler({InvalidAmount.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String invalidAmount(InvalidAmount ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler({EmailAlreadyExist.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String invalidEmail(EmailAlreadyExist ex){
        return ex.getMessage();
    }
}
