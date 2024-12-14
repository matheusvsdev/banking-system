package com.matheusdev.bankingsystem.dto;

import com.matheusdev.bankingsystem.entity.CardEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreateCardDTO {

    private String username;
    private String number;
    private LocalDate expirationDate;
    private String cvv;
    private BigDecimal creditLimit;
    private BigDecimal consumedLimit;
    private BigDecimal availableLimit;
    private UserDTO user;

    public CreateCardDTO() {
    }

    public CreateCardDTO(String username, String number, LocalDate expirationDate, String cvv, BigDecimal creditLimit, BigDecimal consumedLimit, BigDecimal availableLimit, UserDTO user) {
        this.username = username;
        this.number = number;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.creditLimit = creditLimit;
        this.consumedLimit = consumedLimit;
        this.availableLimit = availableLimit;
        this.user = user;
    }

    public CreateCardDTO(CardEntity entity) {
        this.username = entity.getUsername();
        this.number = entity.getNumber();
        this.expirationDate = entity.getExpirationDate();
        this.cvv = entity.getCvv();
        this.creditLimit = entity.getCreditLimit();
        this.consumedLimit = entity.getConsumedLimit();
        this.availableLimit = entity.getAvailableLimit();
        this.user = new UserDTO(entity.getAccount().getUser());
    }

    public String getUsername() {
        return username;
    }

    public String getNumber() {
        return number;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public String getCvv() {
        return cvv;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public BigDecimal getConsumedLimit() {
        return consumedLimit;
    }

    public BigDecimal getAvailableLimit() {
        return availableLimit;
    }

    public UserDTO getUser() {
        return user;
    }
}
