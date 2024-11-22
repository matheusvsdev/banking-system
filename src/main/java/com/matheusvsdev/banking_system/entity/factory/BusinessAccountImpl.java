package com.matheusvsdev.banking_system.entity.factory;

import com.matheusvsdev.banking_system.dto.CreateBusinessAccountDTO;
import com.matheusvsdev.banking_system.dto.CreatePersonalAccountDTO;
import com.matheusvsdev.banking_system.entity.AccountStatus;
import com.matheusvsdev.banking_system.entity.BusinessAccountEntity;
import com.matheusvsdev.banking_system.entity.PersonalAccountEntity;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class BusinessAccountImpl implements BusinesslAccountFactory {
    @Override
    public BusinessAccountEntity createAccount(CreateBusinessAccountDTO dto) {
        BusinessAccountEntity businessAccount = new BusinessAccountEntity();
        businessAccount.setEmployerIdentificationNumber(dto.getEmployerIdentificationNumber());
        businessAccount.setCorporateName(dto.getCorporateName());
        businessAccount.setFictitiousBusinessName(dto.getFictitiousBusinessName());
        businessAccount.setEmail(dto.getEmail());
        businessAccount.setPhone(dto.getPhone());
        businessAccount.setStatus(AccountStatus.ACTIVE);
        businessAccount.setOpeningDate(Instant.now());
        businessAccount.setUser(dto.getUser());
        businessAccount.setAddress(dto.getAddress());

        return businessAccount;
    }
}
