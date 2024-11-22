package com.matheusvsdev.banking_system.dto;

import com.matheusvsdev.banking_system.entity.AddressEntity;
import com.matheusvsdev.banking_system.entity.UserEntity;

public class CreateBusinessAccountDTO {

    private String employerIdentificationNumber;

    private String corporateName;

    private String fictitiousBusinessName;

    private String email;

    private String phone;

    private UserEntity user;

    private AddressEntity address;

    public CreateBusinessAccountDTO() {
    }


    public CreateBusinessAccountDTO(String employerIdentificationNumber, String corporateName, String fictitiousBusinessName, String email, String phone, UserEntity user, AddressEntity address) {
        this.employerIdentificationNumber = employerIdentificationNumber;
        this.corporateName = corporateName;
        this.fictitiousBusinessName = fictitiousBusinessName;
        this.email = email;
        this.phone = phone;
        this.user = user;
        this.address = address;
    }

    public String getEmployerIdentificationNumber() {
        return employerIdentificationNumber;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public String getFictitiousBusinessName() {
        return fictitiousBusinessName;
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
