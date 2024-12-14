package com.matheusdev.bankingsystem.controller;

import com.matheusdev.bankingsystem.dto.ResponseAccountDTO;
import com.matheusdev.bankingsystem.dto.AccountDTO;
import com.matheusdev.bankingsystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<ResponseAccountDTO> createAccount(@RequestBody AccountDTO accountDTO) {
        ResponseAccountDTO account = accountService.createAccount(accountDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(account.getId())
                .toUri();

        return ResponseEntity.created(uri).body(account);
    }
}
