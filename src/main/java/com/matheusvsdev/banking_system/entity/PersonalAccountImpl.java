package com.matheusvsdev.banking_system.entity;

import com.matheusvsdev.banking_system.dto.CreatePersonalAccountDTO;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;

@Component
public class PersonalAccountImpl implements PersonalAccountFactory {
    @Override
    public PersonalAccount createAccount(CreatePersonalAccountDTO dto) {
        PersonalAccount personalAccount = new PersonalAccount();
        personalAccount.setEmail(dto.getEmail());
        personalAccount.setPhone(dto.getPhone());
        personalAccount.setStatus(AccountStatus.ACTIVE);
        personalAccount.setOpeningDate(Instant.now());
        personalAccount.setUser(dto.getUser());
        personalAccount.setAddress(dto.getAddress());

        return personalAccount;
    }
}
