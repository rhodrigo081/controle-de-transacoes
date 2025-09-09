package org.example.model;

import org.example.enums.AccountType;

import java.util.List;

public class CheckingAccount extends Account {

    public CheckingAccount(String id, String ownerName, String ownerCPF, String password, Double balance, List<PixKey> pixKeys, List<Transaction> transactions) {
        super(id, ownerName, ownerCPF, password, AccountType.CHECKING, pixKeys, balance, transactions);
    }
}