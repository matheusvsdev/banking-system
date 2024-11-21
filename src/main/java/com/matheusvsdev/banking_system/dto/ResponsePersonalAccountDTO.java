package com.matheusvsdev.banking_system.dto;

import com.matheusvsdev.banking_system.entity.AccountStatus;
import com.matheusvsdev.banking_system.entity.PersonalAccount;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

public class ResponsePersonalAccountDTO {

    private Long id;

    private String email;

    private String phone;

    private AccountStatus status;

    private Instant openingDate;

    private BigDecimal balance;

    private Long userId;

    private Long addressId;

    public ResponsePersonalAccountDTO() {
    }

    public ResponsePersonalAccountDTO(Long id, String email, String phone, AccountStatus status, Instant openingDate, BigDecimal balance, Long userId, Long addressId) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.openingDate = openingDate;
        this.balance = balance;
        this.userId = userId;
        this.addressId = addressId;
    }

    public static ResponsePersonalAccountDTO fromEntity(PersonalAccount entity) {
        return new ResponsePersonalAccountDTO(
                entity.getId(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getStatus(),
                entity.getOpeningDate(),
                entity.getBalance(),
                entity.getUser().getId(),
                entity.getAddress().getId()
        );
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public Instant getOpeningDate() {
        return openingDate;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getAddressId() {
        return addressId;
    }
}
