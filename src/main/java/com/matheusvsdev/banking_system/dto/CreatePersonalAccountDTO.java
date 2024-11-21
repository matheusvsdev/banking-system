package com.matheusvsdev.banking_system.dto;

import com.matheusvsdev.banking_system.entity.AddressEntity;
import com.matheusvsdev.banking_system.entity.UserEntity;

public class CreatePersonalAccountDTO {

    private String email;

    private String phone;

    private UserEntity user;

    private AddressEntity address;

    public CreatePersonalAccountDTO() {
    }

    public CreatePersonalAccountDTO(String email, String phone, UserEntity user, AddressEntity address) {
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

    public UserEntity getUser() {
        return user;
    }

    public AddressEntity getAddress() {
        return address;
    }
}
