package com.matheusvsdev.banking_system.service.impl;

import com.matheusvsdev.banking_system.dto.CreateBusinessAccountDTO;
import com.matheusvsdev.banking_system.dto.CreatePersonalAccountDTO;
import com.matheusvsdev.banking_system.dto.ResponseBusinessAccountDTO;
import com.matheusvsdev.banking_system.dto.ResponsePersonalAccountDTO;
import com.matheusvsdev.banking_system.entity.BusinessAccountEntity;
import com.matheusvsdev.banking_system.entity.PersonalAccountEntity;
import com.matheusvsdev.banking_system.entity.factory.BusinesslAccountFactory;
import com.matheusvsdev.banking_system.entity.factory.PersonalAccountFactory;
import com.matheusvsdev.banking_system.repository.BusinessAccountRepository;
import com.matheusvsdev.banking_system.repository.PersonalAccountRepository;
import com.matheusvsdev.banking_system.service.BusinessAccountService;
import com.matheusvsdev.banking_system.service.PersonalAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BusinessAccountServiceImpl implements BusinessAccountService {

    private final BusinesslAccountFactory factory;
    private final BusinessAccountRepository repository;

    public BusinessAccountServiceImpl(BusinesslAccountFactory factory, BusinessAccountRepository repository) {
        this.factory = factory;
        this.repository = repository;
    }

    @Override
    @Transactional
    public ResponseBusinessAccountDTO createAccount(CreateBusinessAccountDTO dto) {
        BusinessAccountEntity account = factory.createAccount(dto);
        repository.save(account);

        return ResponseBusinessAccountDTO.fromEntity(account);
    }
}
