package com.matheusdev.bankingsystem.service.impl;

import com.matheusdev.bankingsystem.dto.CreateAccountDTO;
import com.matheusdev.bankingsystem.dto.ResponseAccountDTO;
import com.matheusdev.bankingsystem.entity.Account;
import com.matheusdev.bankingsystem.entity.factory.AccountFactory;
import com.matheusdev.bankingsystem.repository.AccountRepository;
import com.matheusdev.bankingsystem.service.AccountService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountFactory accountFactory;

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    @Override
    public ResponseAccountDTO createAccount(CreateAccountDTO dto) {
        Account account = accountFactory.createAccount(dto);
        return new ResponseAccountDTO(accountRepository.save(account));
    }
}
