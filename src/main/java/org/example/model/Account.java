package org.example.model;


import com.google.cloud.firestore.annotation.DocumentId;

import java.util.List;

public class Account {

    @DocumentId
    protected String id;
    protected String ownerName;
    protected String ownerCPF;
    protected String password;
    protected String type;
    protected String pixKey;
    protected Double balance;
    protected List<Transaction> transactions;

    public Account(String id, String ownerName, String ownerCPF, String password, String type, String pixKey, Double balance, List<Transaction> transactions) {
        this.id = id;
        this.ownerName = ownerName;
        this.ownerCPF = ownerCPF;
        this.password = password;
        this.type = type;
        this.pixKey = pixKey;
        this.balance = balance;
        this.transactions = transactions;
    }

    public Account() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerCPF() {
        return ownerCPF;
    }

    public void setOwnerCPF(String ownerCPF) {
        this.ownerCPF = ownerCPF;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPixKey() {
        return pixKey;
    }

    public void setPixKey(String pixKey) {
        this.pixKey = pixKey;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
