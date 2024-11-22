package com.matheusvsdev.banking_system.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.math.BigDecimal;
import java.time.Instant;
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

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    private Instant openingDate;

    private Instant closingDate;

    private BigDecimal balance = BigDecimal.ZERO;

    @OneToOne
    @JoinColumn(name = "user_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private UserEntity user;

    @OneToOne
    @JoinColumn(name = "address_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private AddressEntity address;

    public BusinessAccountEntity() {
    }

    public BusinessAccountEntity(Long id, String employerIdentificationNumber, String corporateName, String fictitiousBusinessName, String email, String phone, AccountStatus status, Instant openingDate, Instant closingDate, BigDecimal balance, UserEntity user, AddressEntity address) {
        this.id = id;
        this.employerIdentificationNumber = employerIdentificationNumber;
        this.corporateName = corporateName;
        this.fictitiousBusinessName = fictitiousBusinessName;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.openingDate = openingDate;
        this.closingDate = closingDate;
        this.balance = balance;
        this.user = user;
        this.address = address;
    }

    @Override
    public void deposit(BigDecimal amount) {
        this.balance = balance.add(amount);
    }

    @Override
    public void withdraw(BigDecimal amount) {
        this.balance = balance.subtract(amount);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployerIdentificationNumber() {
        return employerIdentificationNumber;
    }

    public void setEmployerIdentificationNumber(String employerIdentificationNumber) {
        this.employerIdentificationNumber = employerIdentificationNumber;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public String getFictitiousBusinessName() {
        return fictitiousBusinessName;
    }

    public void setFictitiousBusinessName(String fictitiousBusinessName) {
        this.fictitiousBusinessName = fictitiousBusinessName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public Instant getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Instant openingDate) {
        this.openingDate = openingDate;
    }

    public Instant getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Instant closingDate) {
        this.closingDate = closingDate;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }
}
