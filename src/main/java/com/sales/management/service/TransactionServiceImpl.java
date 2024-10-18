package com.sales.management.service;

import com.sales.management.model.Transaction;
import com.sales.management.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getTransaction(Long id) {
        return transactionRepository.findById(id).get();
    }

    @Override
    public void updateTransaction(Transaction transaction) {
        Optional<Transaction> transaction1 = transactionRepository.findById(transaction.getId());
        Transaction newTransaction = transaction1.get();

        if (transaction1.isPresent())
        {
            newTransaction.setProduct(transaction.getProduct());
            newTransaction.setPrice(transaction.getPrice());
            newTransaction.setQuantity(transaction.getQuantity());
            newTransaction.setSales(transaction.getSales());
            transactionRepository.save(newTransaction);
        }
        else
            throw new RuntimeException("transaction not found");
    }
}
