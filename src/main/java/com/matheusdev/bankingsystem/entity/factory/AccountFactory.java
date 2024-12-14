package com.matheusdev.bankingsystem.entity.factory;

import com.matheusdev.bankingsystem.dto.AccountDTO;
import com.matheusdev.bankingsystem.entity.AccountEntity;

public interface AccountFactory {
    AccountEntity createAccount(AccountDTO accountDTO);
}
