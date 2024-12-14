package com.matheusdev.bankingsystem.dto;

import com.matheusdev.bankingsystem.entity.AccountEntity;

import java.math.BigDecimal;
import java.time.Instant;

public class ResponseAccountDTO {

    private Long id;
    private String agency;
    private String accountNumber;
    private BigDecimal balance;
    private Instant openingDate;
    private AccountEntity.Status status;
    private ResponseUserDTO user;

    public ResponseAccountDTO() {
    }

    public ResponseAccountDTO(Long id, String agency, String accountNumber, BigDecimal balance, Instant openingDate, AccountEntity.Status status, ResponseUserDTO user) {
        this.id = id;
        this.agency = agency;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.openingDate = openingDate;
        this.status = status;
        this.user = user;
    }

    public ResponseAccountDTO(AccountEntity entity) {
        this.id = entity.getId();
        this.agency = entity.getAgency();
        this.accountNumber = entity.getAccountNumber();
        this.balance = entity.getBalance();
        this.openingDate = entity.getOpeningDate();
        this.status = entity.getStatus();
        this.user = new ResponseUserDTO(entity.getUser());
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

    public ResponseUserDTO getUser() {
        return user;
    }
}
