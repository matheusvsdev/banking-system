package com.matheusdev.bankingsystem.dto;

import com.matheusdev.bankingsystem.entity.AccountEntity;

public class CreateAccountDTO {

    private CreateUserDTO user;

    public CreateAccountDTO() {
    }

    public CreateAccountDTO(CreateUserDTO user) {
        this.user = user;
    }

    public CreateAccountDTO(AccountEntity entity) {
        this.user = new CreateUserDTO(entity.getUser());
    }

    public CreateUserDTO getUser() {
        return user;
    }
}
