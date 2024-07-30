package com.example.demo.dao;

import com.example.demo.entity.transaction.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDaoRepository extends CrudRepository<Transaction, Long> {
}
