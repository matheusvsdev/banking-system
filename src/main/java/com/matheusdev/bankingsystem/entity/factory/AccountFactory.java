package com.matheusdev.bankingsystem.entity.factory;

import com.matheusdev.bankingsystem.dto.CreateAccountDTO;
import com.matheusdev.bankingsystem.entity.AccountEntity;

public interface AccountFactory {
    AccountEntity createAccount(CreateAccountDTO createAccountDTO);
}
