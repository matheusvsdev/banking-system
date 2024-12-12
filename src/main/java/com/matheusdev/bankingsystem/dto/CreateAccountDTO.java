package com.matheusdev.bankingsystem.dto;

import com.matheusdev.bankingsystem.entity.Account;
import com.matheusdev.bankingsystem.entity.enums.AccountType;

public class CreateAccountDTO {

    private AccountType accountType;

    private CreateUserDTO user;

    public CreateAccountDTO() {
    }

    public CreateAccountDTO(AccountType accountType, CreateUserDTO user) {
        this.accountType = accountType;
        this.user = user;
    }

    public CreateAccountDTO(Account entity) {
        this.accountType = entity.getAccountType();
        this.user = new CreateUserDTO(entity.getUser());
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public CreateUserDTO getUser() {
        return user;
    }
}
