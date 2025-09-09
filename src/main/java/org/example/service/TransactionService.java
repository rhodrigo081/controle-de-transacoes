package org.example.service;

import org.example.enums.TransactionType;
import org.example.model.Account;
import org.example.model.Transaction;
import org.example.repository.TransactionRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class TransactionService implements TransactionRepository {

    @Override
    public Transaction createTransaction(String accountSenderId, String accountReceiverId, LocalDateTime date, TransactionType type, Double value) throws ExecutionException, InterruptedException{
        try{
            date = LocalDateTime.now();

            if(accountSenderId.isEmpty() || accountReceiverId.isEmpty()){

            }
        } catch (Throwable e){
            throw new ExecutionException(e.getMessage(), e);
        }
    }

    @Override
    public List<Transaction> accountStatement(String accountId) throws ExecutionException, InterruptedException{
        return ;
    }
}
