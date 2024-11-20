package com.matheusvsdev.banking_system.dto;

import com.matheusvsdev.banking_system.entity.Address;
import com.matheusvsdev.banking_system.entity.User;

import java.time.LocalDate;

public class UserCreateDTO {

    private String userImageUrl;

    private String fullName;

    private String cpf;

    private LocalDate birthDate;

    private Address address;

    public UserCreateDTO() {
    }

    public UserCreateDTO(String userImageUrl, String fullName, String cpf, LocalDate birthDate, Address address) {
        this.userImageUrl = userImageUrl;
        this.fullName = fullName;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.address = address;
    }

    public UserCreateDTO(User entity) {
        userImageUrl = entity.getUserImageUrl();
        fullName = entity.getFullName();
        cpf = entity.getCpf();
        birthDate = entity.getBirthDate();
        address = new Address();
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Address getAddress() {
        return address;
    }
}
