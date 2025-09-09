package org.example.repository;

import org.example.model.Account;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ExecutionException;

@Repository
public interface AccountRepository {
    Account createAccount(String ownerName, String ownerCPF, String password, String type) throws ExecutionException, InterruptedException;

    Account loginAccount(String ownerCPF, String password) throws ExecutionException, InterruptedException;

    Account findByOwnerName(String ownerName) throws ExecutionException, InterruptedException;

    Account findByOwnerCPF(String ownerCPF) throws ExecutionException, InterruptedException;

    void deleteById(String id) throws ExecutionException, InterruptedException;
}