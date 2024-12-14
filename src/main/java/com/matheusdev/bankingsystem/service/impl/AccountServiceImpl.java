package com.matheusdev.bankingsystem.service.impl;

import com.matheusdev.bankingsystem.dto.ResponseAccountDTO;
import com.matheusdev.bankingsystem.dto.AccountDTO;
import com.matheusdev.bankingsystem.entity.AccountEntity;
import com.matheusdev.bankingsystem.entity.factory.AccountFactory;
import com.matheusdev.bankingsystem.repository.AccountRepository;
import com.matheusdev.bankingsystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountFactory accountFactory;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public ResponseAccountDTO createAccount(AccountDTO accountDTO) {
        AccountEntity account = accountFactory.createAccount(accountDTO);
        return new ResponseAccountDTO(accountRepository.save(account));
    }
}
