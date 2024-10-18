package com.sales.management.service;

import com.sales.management.model.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getAllTransactions();
    Transaction getTransaction(Long id);
    void updateTransaction(Transaction transaction);

}
