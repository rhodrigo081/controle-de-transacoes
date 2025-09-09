package org.example.repository;

import org.example.enums.TransactionType;
import org.example.model.Transaction;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public interface TransactionRepository {

    Transaction createTransaction(String accountSenderId, String accountReceiverId, LocalDateTime date, TransactionType type, Double value) throws ExecutionException, InterruptedException;

    List<Transaction> accountStatement(String accountId) throws ExecutionException, InterruptedException;
}
