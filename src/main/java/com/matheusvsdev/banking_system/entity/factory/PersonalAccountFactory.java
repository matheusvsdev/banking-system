package com.matheusvsdev.banking_system.entity.factory;

import com.matheusvsdev.banking_system.dto.CreatePersonalAccountDTO;
import com.matheusvsdev.banking_system.entity.PersonalAccountEntity;

public interface PersonalAccountFactory {
    PersonalAccountEntity createAccount(CreatePersonalAccountDTO personalAccount);
}
