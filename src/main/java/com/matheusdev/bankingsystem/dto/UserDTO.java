package com.matheusdev.bankingsystem.dto;

import com.matheusdev.bankingsystem.entity.UserEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class UserDTO {

    private String fullName;
    private String cpf;
    private LocalDate birthDate;
    private BigDecimal salary;
    private String email;
    private String password;

    public UserDTO() {
    }

    public UserDTO(String fullName, String cpf, LocalDate birthDate, BigDecimal salary, String email, String password) {
        this.fullName = fullName;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.salary = salary;
        this.email = email;
        this.password = password;
    }

    public UserDTO(UserEntity entity) {
        this.fullName = entity.getFullName();
        this.cpf = entity.getCpf();
        this.birthDate = entity.getBirthDate();
        this.salary = entity.getSalary();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
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

    public BigDecimal getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
