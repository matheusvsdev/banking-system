package com.matheusdev.bankingsystem.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_card")
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String number;
    private LocalDate expirationDate;
    private String cvv;
    private BigDecimal creditLimit;
    private BigDecimal consumedLimit;
    private BigDecimal availableLimit;

    @OneToOne(mappedBy = "card")
    private AccountEntity account;

    public CardEntity() {
    }

    public CardEntity(Long id, String username, String number, LocalDate expirationDate, String cvv, BigDecimal creditLimit, BigDecimal consumedLimit, BigDecimal availableLimit, AccountEntity account) {
        this.id = id;
        this.username = username;
        this.number = number;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.creditLimit = creditLimit;
        this.consumedLimit = consumedLimit;
        this.availableLimit = availableLimit;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getConsumedLimit() {
        return consumedLimit;
    }

    public void setConsumedLimit(BigDecimal consumedLimit) {
        this.consumedLimit = consumedLimit;
    }

    public BigDecimal getAvailableLimit() {
        return availableLimit;
    }

    public void setAvailableLimit(BigDecimal availableLimit) {
        this.availableLimit = availableLimit;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        CardEntity that = (CardEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
