package com.matheusdev.bankingsystem.entity.enums;

public enum AccountType {
    PERSONAL("Pessoa Física"),
    BUSINESS("Pessoa Jurídica");

    private String description;

    AccountType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
