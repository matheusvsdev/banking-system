package com.matheusdev.bankingsystem.entity.enums;

public enum AccountStatus {
    ACTIVE("Ativa"),
    INACTIVE("Inativa");

    private final String description;

    AccountStatus(String description) {
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
