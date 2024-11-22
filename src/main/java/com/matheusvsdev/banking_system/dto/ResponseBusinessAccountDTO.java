package com.matheusvsdev.banking_system.dto;

import com.matheusvsdev.banking_system.entity.*;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import org.hibernate.annotations.Cascade;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

public class ResponseBusinessAccountDTO {

    private Long id;

    private String employerIdentificationNumber;

    private String corporateName;

    private String fictitiousBusinessName;

    private String email;

    private String phone;

    private AccountStatus status;

    private Instant openingDate;

    private BigDecimal balance;

    private UserEntity user;

    private AddressEntity address;

    public ResponseBusinessAccountDTO() {
    }

    public ResponseBusinessAccountDTO(Long id, String employerIdentificationNumber, String corporateName, String fictitiousBusinessName, String email, String phone, AccountStatus status, Instant openingDate, BigDecimal balance, UserEntity user, AddressEntity address) {
        this.id = id;
        this.employerIdentificationNumber = employerIdentificationNumber;
        this.corporateName = corporateName;
        this.fictitiousBusinessName = fictitiousBusinessName;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.openingDate = openingDate;
        this.balance = balance;
        this.user = user;
        this.address = address;
    }

    public static ResponseBusinessAccountDTO fromEntity(BusinessAccountEntity entity) {
        return new ResponseBusinessAccountDTO(
                entity.getId(),
                entity.getEmployerIdentificationNumber(),
                entity.getCorporateName(),
                entity.getFictitiousBusinessName(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getStatus(),
                entity.getOpeningDate(),
                entity.getBalance(),
                entity.getUser(),
                entity.getAddress()
        );
    }

    public Long getId() {
        return id;
    }

    public String getEmployerIdentificationNumber() {
        return employerIdentificationNumber;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public String getFictitiousBusinessName() {
        return fictitiousBusinessName;
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

    public UserEntity getUser() {
        return user;
    }

    public AddressEntity getAddress() {
        return address;
    }
}
