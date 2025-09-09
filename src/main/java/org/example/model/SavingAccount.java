package org.example.model;

import java.util.List;

public class SavingAccount extends Account {
    public SavingAccount(String id, String ownerName, String ownerCPF, String password, String type, Double balance, List<Transaction> transactions) {
        super(id, ownerName, ownerCPF, password, type, balance, transactions);
    }
}
