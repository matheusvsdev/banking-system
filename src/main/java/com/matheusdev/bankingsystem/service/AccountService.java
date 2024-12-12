package com.matheusdev.bankingsystem.service;

import com.matheusdev.bankingsystem.dto.CreateAccountDTO;
import com.matheusdev.bankingsystem.dto.ResponseAccountDTO;

public interface AccountService {
    ResponseAccountDTO createAccount(CreateAccountDTO accountDTO);
}
