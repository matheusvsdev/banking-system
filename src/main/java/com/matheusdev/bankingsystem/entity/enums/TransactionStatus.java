package com.matheusdev.bankingsystem.entity.enums;

public enum TransactionStatus {
    COMPLETED("Concluída"),
    DENIED("Negada"),
    PENDING("Pendente"),
    CANCELLED("Cancelada");

    private final String description;

    TransactionStatus(String description) {
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
