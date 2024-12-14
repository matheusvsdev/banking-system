package com.matheusdev.bankingsystem.dto;

import com.matheusdev.bankingsystem.entity.UserEntity;

import java.time.LocalDate;

public class UserDTO {

    private Long id;
    private String fullName;
    private String cpf;
    private LocalDate birthDate;
    private String email;

    public UserDTO() {
    }

    public UserDTO(Long id, String fullName, String cpf, LocalDate birthDate, String email) {
        this.id = id;
        this.fullName = fullName;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.email = email;
    }

    public UserDTO(UserEntity entity) {
        this.id = entity.getId();
        this.fullName = entity.getFullName();
        this.cpf = entity.getCpf();
        this.birthDate = entity.getBirthDate();
        this.email = entity.getEmail();
    }

    public Long getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

}
