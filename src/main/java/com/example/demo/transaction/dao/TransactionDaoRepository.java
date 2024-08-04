package com.example.demo.transaction.dao;

import com.example.demo.transaction.entity.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDaoRepository extends CrudRepository<Transaction, Long> {
}
