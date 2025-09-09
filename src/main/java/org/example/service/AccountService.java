package org.example.service;

import com.google.api.gax.rpc.NotFoundException;
import org.example.model.Account;
import org.example.repository.AccountRepository;
import org.example.utils.PassworUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account, String confirmePassword) throws ExecutionException, InterruptedException {
        try {
            if (account.getOwnerCPF().isEmpty() || account.getOwnerName().isEmpty() || account.getPassword().isEmpty()) {
                throw new IllegalArgumentException("Todos os campos são obrigatórios!");
            }

            if (accountRepository.findByOwnerCPF(account.getOwnerCPF()) != null) {
                throw new IllegalArgumentException("CPF já cadastrado!");
            }

            if (!confirmePassword.equals(account.getPassword())) {
                throw new IllegalArgumentException("Senhas diferentes!");
            }

            String hashedPassword = PassworUtils.hashPassword(account.getPassword());
            account.setPassword(hashedPassword);

            return accountRepository.createAccount(account);
        } catch (InterruptedException | ExecutionException e) {
            throw e;
        }
    }

    public Account login(String login, String password) throws ExecutionException, InterruptedException {

        try {
            if(login.isEmpty() || password.isEmpty()) {
                throw new IllegalArgumentException("Tdos os campos são obrigatórios!");
            }

            if(login.contains("@")) {}

            return
        }

    }

}