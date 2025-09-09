package org.example.model;

import java.time.LocalDate;

public class Transaction {
    protected String id;
    protected LocalDate date;
    protected String type;
    protected Double value;

    public Transaction(String id, LocalDate date, String type, Double value) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
