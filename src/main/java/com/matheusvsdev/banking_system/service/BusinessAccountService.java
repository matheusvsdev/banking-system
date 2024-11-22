package com.matheusvsdev.banking_system.service;

import com.matheusvsdev.banking_system.dto.CreateBusinessAccountDTO;
import com.matheusvsdev.banking_system.dto.CreatePersonalAccountDTO;
import com.matheusvsdev.banking_system.dto.ResponseBusinessAccountDTO;
import com.matheusvsdev.banking_system.dto.ResponsePersonalAccountDTO;

public interface BusinessAccountService {
    ResponseBusinessAccountDTO createAccount(CreateBusinessAccountDTO dto);
}
