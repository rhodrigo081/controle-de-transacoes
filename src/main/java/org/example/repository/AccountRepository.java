package org.example.repository;

import org.example.enums.AccountType;
import org.example.model.Account;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ExecutionException;

@Repository
public interface AccountRepository {
    Account createAccount(Account account) throws ExecutionException, InterruptedException;

    Account findByPixKey(String pixKey) throws ExecutionException, InterruptedException;

    Account findByOwnerCPF(String ownerCPF) throws ExecutionException, InterruptedException;

    void deleteById(String id) throws ExecutionException, InterruptedException;
}