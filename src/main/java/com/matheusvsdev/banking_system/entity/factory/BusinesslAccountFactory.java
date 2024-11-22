package com.matheusvsdev.banking_system.entity.factory;

import com.matheusvsdev.banking_system.dto.CreateBusinessAccountDTO;
import com.matheusvsdev.banking_system.dto.CreatePersonalAccountDTO;
import com.matheusvsdev.banking_system.entity.BusinessAccountEntity;
import com.matheusvsdev.banking_system.entity.PersonalAccountEntity;

public interface BusinesslAccountFactory {
    BusinessAccountEntity createAccount(CreateBusinessAccountDTO businessAccountDTO);
}
