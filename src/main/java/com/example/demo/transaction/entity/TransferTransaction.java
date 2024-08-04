package com.example.demo.transaction.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TransferTransaction {
    private String destination_account_id;
    private double amount;
}
