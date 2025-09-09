package org.example.model;

import java.util.List;

public class CheckingAccount extends Account {
    public CheckingAccount(String id, String ownerName, String ownerCPF, String password, String type, Double balance, List<Transaction> transactions) {
        super(id, ownerName, ownerCPF, password, type, balance, transactions);
    }
}
