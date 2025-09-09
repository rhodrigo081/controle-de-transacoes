package org.example.enums;

public enum AccountType {
    CHECKING(1),
    SAVINGS(2),
    ;

    protected int value;
    AccountType(int optionValue) {
        this.value = optionValue;
    }

    public int getValue() {
        return value;
    }
}
