package com.matheusdev.bankingsystem.service;

import com.matheusdev.bankingsystem.dto.ResponseAccountDTO;
import com.matheusdev.bankingsystem.dto.AccountDTO;

public interface AccountService {
    ResponseAccountDTO createAccount(AccountDTO accountDTO);
}
