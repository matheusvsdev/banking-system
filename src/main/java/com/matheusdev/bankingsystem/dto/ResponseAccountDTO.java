package com.matheusdev.bankingsystem.dto;

import com.matheusdev.bankingsystem.entity.Account;
import com.matheusdev.bankingsystem.entity.User;
import com.matheusdev.bankingsystem.entity.enums.AccountStatus;
import com.matheusdev.bankingsystem.entity.enums.AccountType;

import java.math.BigDecimal;
import java.time.Instant;

public class ResponseAccountDTO {

    private Long id;
    private String agency;
    private String accountNumber;
    private BigDecimal balance;
    private Instant openingDate;
    private AccountType accountType;
    private AccountStatus accountStatus;
    private User user;

    public ResponseAccountDTO() {
    }

    public ResponseAccountDTO(Long id, String agency, String accountNumber, BigDecimal balance, Instant openingDate, AccountType accountType, AccountStatus accountStatus, User user) {
        this.id = id;
        this.agency = agency;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.openingDate = openingDate;
        this.accountType = accountType;
        this.accountStatus = accountStatus;
        this.user = user;
    }

    public ResponseAccountDTO(Account account) {
        this.id = account.getId();
        this.agency = account.getAgency();
        this.accountNumber = account.getAccountNumber();
        this.balance = account.getBalance();
        this.openingDate = account.getOpeningDate();
        this.accountType = account.getAccountType();
        this.accountStatus = account.getAccountStatus();
        this.user = account.getUser();
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

    public AccountType getAccountType() {
        return accountType;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "ResponseAccountDTO{" +
                "id=" + id +
                ", agency='" + agency + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", openingDate=" + openingDate +
                ", accountType=" + accountType +
                ", accountStatus=" + accountStatus +
                ", user=" + user +
                '}';
    }
}
