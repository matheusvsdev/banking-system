package com.matheusvsdev.banking_system.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userImageUrl;

    private String fullName;

    private String socialSecurityNumber;

    private LocalDate birthDate;

    @OneToOne(mappedBy = "user")
    private PersonalAccountEntity personalAccount;

    @OneToMany(mappedBy = "user")
    private List<BusinessAccountEntity> businessAccounts;

    public UserEntity() {
    }

    public UserEntity(Long id, String userImageUrl, String fullName, String socialSecurityNumber, LocalDate birthDate) {
        this.id = id;
        this.userImageUrl = userImageUrl;
        this.fullName = fullName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public PersonalAccountEntity getPersonalAccount() {
        return personalAccount;
    }

    public void setPersonalAccount(PersonalAccountEntity personalAccount) {
        this.personalAccount = personalAccount;
    }

    public List<BusinessAccountEntity> getBusinessAccounts() {
        return businessAccounts;
    }

    public void setBusinessAccounts(List<BusinessAccountEntity> businessAccounts) {
        this.businessAccounts = businessAccounts;
    }
}
