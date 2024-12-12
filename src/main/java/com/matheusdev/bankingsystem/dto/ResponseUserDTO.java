package com.matheusdev.bankingsystem.dto;

import com.matheusdev.bankingsystem.entity.User;

import java.time.LocalDate;

public class ResponseUserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;

    public ResponseUserDTO() {
    }

    public ResponseUserDTO(Long id, String firstName, String lastName, LocalDate birthDate, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
    }

    public ResponseUserDTO(User entity) {
        this.id = entity.getId();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.birthDate = entity.getBirthDate();
        this.email = entity.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }
}
