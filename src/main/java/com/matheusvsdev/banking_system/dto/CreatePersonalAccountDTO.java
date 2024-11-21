package com.matheusvsdev.banking_system.dto;

import com.matheusvsdev.banking_system.entity.Address;
import com.matheusvsdev.banking_system.entity.User;

public class CreatePersonalAccountDTO {

    private String email;

    private String phone;

    private User user;

    private Address address;

    public CreatePersonalAccountDTO() {
    }

    public CreatePersonalAccountDTO(String email, String phone, User user, Address address) {
        this.email = email;
        this.phone = phone;
        this.user = user;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public User getUser() {
        return user;
    }

    public Address getAddress() {
        return address;
    }
}
