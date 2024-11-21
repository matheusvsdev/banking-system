package com.matheusvsdev.banking_system.service;

import com.matheusvsdev.banking_system.dto.CreatePersonalAccountDTO;
import com.matheusvsdev.banking_system.dto.ResponsePersonalAccountDTO;
import com.matheusvsdev.banking_system.entity.PersonalAccount;
import com.matheusvsdev.banking_system.entity.PersonalAccountFactory;
import com.matheusvsdev.banking_system.repository.PersonalAccountRepository;
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
        PersonalAccount account = factory.createAccount(dto);
        repository.save(account);

        return ResponsePersonalAccountDTO.fromEntity(account);
    }
}
