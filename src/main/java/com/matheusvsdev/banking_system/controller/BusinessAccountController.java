package com.matheusvsdev.banking_system.controller;

import com.matheusvsdev.banking_system.dto.CreateBusinessAccountDTO;
import com.matheusvsdev.banking_system.dto.CreatePersonalAccountDTO;
import com.matheusvsdev.banking_system.dto.ResponseBusinessAccountDTO;
import com.matheusvsdev.banking_system.dto.ResponsePersonalAccountDTO;
import com.matheusvsdev.banking_system.service.BusinessAccountService;
import com.matheusvsdev.banking_system.service.PersonalAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/businessAccount")
public class BusinessAccountController {

    private BusinessAccountService businessAccountService;

    public BusinessAccountController(BusinessAccountService businessAccountService) {
        this.businessAccountService = businessAccountService;
    }

    @PostMapping
    public ResponseEntity<ResponseBusinessAccountDTO> createPersonalAccount(@RequestBody CreateBusinessAccountDTO dto) {
        ResponseBusinessAccountDTO businessAccountDTO = businessAccountService.createAccount(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(businessAccountDTO.getId())
                .toUri();

        return ResponseEntity.created(uri).body(businessAccountDTO);
    }
}
