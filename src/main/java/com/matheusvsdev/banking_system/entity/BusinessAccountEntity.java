package com.matheusvsdev.banking_system.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_business_accounts")
public class BusinessAccountEntity extends Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employerIdentificationNumber;

    private String corporateName;

    private String fictitiousBusinessName;

    private String email;

    private String phone;

    private AccountStatus status;

    private LocalDate openingDate;

    private LocalDate closingDate;

    private BigDecimal balance = BigDecimal.ZERO;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public BusinessAccountEntity() {
    }

    @Override
    public void deposit(BigDecimal amount) {
        this.balance = balance.add(amount);
    }

    @Override
    public void withdraw(BigDecimal amount) {
        this.balance = balance.subtract(amount);
    }
}
