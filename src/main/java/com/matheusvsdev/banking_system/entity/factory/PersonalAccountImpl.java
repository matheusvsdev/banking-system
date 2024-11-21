package com.matheusvsdev.banking_system.entity.factory;

import com.matheusvsdev.banking_system.dto.CreatePersonalAccountDTO;
import com.matheusvsdev.banking_system.entity.AccountStatus;
import com.matheusvsdev.banking_system.entity.PersonalAccountEntity;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class PersonalAccountImpl implements PersonalAccountFactory {
    @Override
    public PersonalAccountEntity createAccount(CreatePersonalAccountDTO dto) {
        PersonalAccountEntity personalAccount = new PersonalAccountEntity();
        personalAccount.setEmail(dto.getEmail());
        personalAccount.setPhone(dto.getPhone());
        personalAccount.setStatus(AccountStatus.ACTIVE);
        personalAccount.setOpeningDate(Instant.now());
        personalAccount.setUser(dto.getUser());
        personalAccount.setAddress(dto.getAddress());

        return personalAccount;
    }
}
