package com.matheusdev.bankingsystem.entity.factory;

import com.matheusdev.bankingsystem.dto.CreateAccountDTO;
import com.matheusdev.bankingsystem.entity.Account;

public interface AccountFactory {
    Account createAccount(CreateAccountDTO dto);
}
