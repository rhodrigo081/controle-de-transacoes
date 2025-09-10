package org.example.repository;

import org.example.model.Account;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ExecutionException;

@Repository
public interface AccountRepository {
    Account createAccount(Account account) throws ExecutionException, InterruptedException;

    Account login(String login, String password) throws ExecutionException, InterruptedException;

    Account getByLogin(String login) throws ExecutionException, InterruptedException;

    Account findByPixKey(String pixKey) throws ExecutionException, InterruptedException;

    Account findByEmail(String email) throws ExecutionException, InterruptedException;

    Account findByDocument(String document) throws ExecutionException, InterruptedException;

    void deleteById(String id) throws ExecutionException, InterruptedException;
}