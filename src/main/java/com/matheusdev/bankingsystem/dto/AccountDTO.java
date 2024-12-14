package com.matheusdev.bankingsystem.dto;

import com.matheusdev.bankingsystem.entity.AccountEntity;

public class AccountDTO {

    private UserDTO user;

    public AccountDTO() {
    }

    public AccountDTO(UserDTO user) {
        this.user = user;
    }

    public AccountDTO(AccountEntity entity) {
        this.user = new UserDTO(entity.getUser());
    }

    public UserDTO getUser() {
        return user;
    }
}
