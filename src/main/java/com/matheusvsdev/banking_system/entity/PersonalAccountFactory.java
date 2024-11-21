package com.matheusvsdev.banking_system.entity;

import com.matheusvsdev.banking_system.dto.CreatePersonalAccountDTO;

public interface PersonalAccountFactory {
    PersonalAccount createAccount(CreatePersonalAccountDTO personalAccount);
}
