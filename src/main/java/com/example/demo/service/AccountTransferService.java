package com.example.demo.service;

import com.example.demo.transaction.entity.Transaction;
import com.example.demo.transaction.entity.TransferTransaction;

public interface AccountTransferService {
    Transaction transfer(String accountId, TransferTransaction transferTransaction);
}
