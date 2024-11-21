package com.matheusvsdev.banking_system.service.impl;

import com.matheusvsdev.banking_system.dto.CreatePersonalAccountDTO;
import com.matheusvsdev.banking_system.dto.ResponsePersonalAccountDTO;
import com.matheusvsdev.banking_system.entity.PersonalAccountEntity;
import com.matheusvsdev.banking_system.entity.factory.PersonalAccountFactory;
import com.matheusvsdev.banking_system.repository.PersonalAccountRepository;
import com.matheusvsdev.banking_system.service.PersonalAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonalAccountServiceImpl implements PersonalAccountService {

    private final PersonalAccountFactory factory;
    private final PersonalAccountRepository repository;

    public PersonalAccountServiceImpl(PersonalAccountFactory factory, PersonalAccountRepository repository) {
        this.factory = factory;
        this.repository = repository;
    }

    @Override
    @Transactional
    public ResponsePersonalAccountDTO createAccount(CreatePersonalAccountDTO dto) {
        PersonalAccountEntity account = factory.createAccount(dto);
        repository.save(account);

        return ResponsePersonalAccountDTO.fromEntity(account);
    }
}
