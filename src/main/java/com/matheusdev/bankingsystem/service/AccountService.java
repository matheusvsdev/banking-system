package com.matheusdev.bankingsystem.service;

import com.matheusdev.bankingsystem.dto.AccountDTO;
import com.matheusdev.bankingsystem.dto.CreateAccountDTO;

public interface AccountService {
    AccountDTO createAccount(CreateAccountDTO createAccountDTO);
}
