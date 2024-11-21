package com.matheusvsdev.banking_system.controller;

import com.matheusvsdev.banking_system.dto.CreatePersonalAccountDTO;
import com.matheusvsdev.banking_system.dto.ResponsePersonalAccountDTO;
import com.matheusvsdev.banking_system.service.PersonalAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/personalAccount")
public class PersonalAccountController {

    private PersonalAccountService personalAccountService;

    public PersonalAccountController(PersonalAccountService personalAccountService) {
        this.personalAccountService = personalAccountService;
    }

    @PostMapping
    public ResponseEntity<ResponsePersonalAccountDTO> createPersonalAccount(@RequestBody CreatePersonalAccountDTO dto) {
        ResponsePersonalAccountDTO personalAccountDTO = personalAccountService.createAccount(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(personalAccountDTO.getId())
                .toUri();

        return ResponseEntity.created(uri).body(personalAccountDTO);
    }
}
