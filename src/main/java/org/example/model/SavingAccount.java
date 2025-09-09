package org.example.model;

import org.example.enums.AccountType;

import java.util.List;

public class SavingAccount extends Account {
    public SavingAccount(String id, String ownerName, String ownerCPF, String password, Double balance, List<PixKey> pixKeys, List<Transaction> transactions) {
        super(id, ownerName, ownerCPF, password, AccountType.SAVING, pixKeys, balance, transactions);
    }
}
