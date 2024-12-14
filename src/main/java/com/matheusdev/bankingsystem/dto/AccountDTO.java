package com.matheusdev.bankingsystem.dto;

import com.matheusdev.bankingsystem.entity.AccountEntity;

import java.math.BigDecimal;
import java.time.Instant;

public class AccountDTO {

    private Long id;
    private String agency;
    private String accountNumber;
    private BigDecimal balance;
    private Instant openingDate;
    private AccountEntity.Status status;
    private UserDTO user;

    public AccountDTO() {
    }

    public AccountDTO(Long id, String agency, String accountNumber, BigDecimal balance, Instant openingDate, AccountEntity.Status status, UserDTO user) {
        this.id = id;
        this.agency = agency;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.openingDate = openingDate;
        this.status = status;
        this.user = user;
    }

    public AccountDTO(AccountEntity entity) {
        this.id = entity.getId();
        this.agency = entity.getAgency();
        this.accountNumber = entity.getAccountNumber();
        this.balance = entity.getBalance();
        this.openingDate = entity.getOpeningDate();
        this.status = entity.getStatus();
        this.user = new UserDTO(entity.getUser());
    }

    public Long getId() {
        return id;
    }

    public String getAgency() {
        return agency;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Instant getOpeningDate() {
        return openingDate;
    }

    public AccountEntity.Status getStatus() {
        return status;
    }

    public UserDTO getUser() {
        return user;
    }
}
