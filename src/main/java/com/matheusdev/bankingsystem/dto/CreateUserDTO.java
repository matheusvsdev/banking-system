package com.matheusdev.bankingsystem.dto;

import com.matheusdev.bankingsystem.entity.User;

import java.time.LocalDate;

public class CreateUserDTO {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String password;

    public CreateUserDTO() {
    }

    public CreateUserDTO(String firstName, String lastName, LocalDate birthDate, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
    }

    public CreateUserDTO(User entity) {
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.birthDate = entity.getBirthDate();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
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

    public String getPassword() {
        return password;
    }
}
