package com.example.demo.account.domen;

import com.example.demo.account.util.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Account {
    private AccountType accountType;
    private String id;
    private String clientID;
    private double balance;
    private boolean withdrawAllowed;
}
