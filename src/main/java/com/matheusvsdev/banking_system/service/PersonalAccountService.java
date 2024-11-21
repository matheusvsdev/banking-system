package com.matheusvsdev.banking_system.service;

import com.matheusvsdev.banking_system.dto.CreatePersonalAccountDTO;
import com.matheusvsdev.banking_system.dto.ResponsePersonalAccountDTO;

public interface PersonalAccountService {
    ResponsePersonalAccountDTO createAccount(CreatePersonalAccountDTO dto);
}
