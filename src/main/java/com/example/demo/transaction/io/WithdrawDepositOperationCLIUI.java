package com.example.demo.transaction.io;

import org.springframework.stereotype.Component;

@Component
public interface WithdrawDepositOperationCLIUI {
    double requestClientAmount();
    String requestClientAccountNumber();
}
