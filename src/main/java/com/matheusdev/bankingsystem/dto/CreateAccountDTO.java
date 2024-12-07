package com.matheusdev.bankingsystem.dto;

import com.matheusdev.bankingsystem.entity.Account;
import com.matheusdev.bankingsystem.entity.User;
import com.matheusdev.bankingsystem.entity.enums.AccountType;

public class CreateAccountDTO {

    private AccountType accountType;

    private User user;

    public CreateAccountDTO() {
    }

    public CreateAccountDTO(AccountType accountType, User user) {
        this.accountType = accountType;
        this.user = user;
    }

    public CreateAccountDTO(Account entity) {
        this.accountType = entity.getAccountType();
        this.user = new User();
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public User getUser() {
        return user;
    }
}
