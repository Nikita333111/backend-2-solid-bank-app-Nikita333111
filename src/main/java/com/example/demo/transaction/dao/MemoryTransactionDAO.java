package com.example.demo.transaction.dao;

import com.example.demo.transaction.domen.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryTransactionDAO implements TransactionDAO {
    private List<Transaction> transactions;

    public MemoryTransactionDAO(){
        this.transactions = new ArrayList<>();
    }

    @Override
    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
