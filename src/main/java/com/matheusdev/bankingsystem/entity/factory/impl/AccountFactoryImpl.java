package com.matheusdev.bankingsystem.entity.factory.impl;

import com.matheusdev.bankingsystem.dto.AccountDTO;
import com.matheusdev.bankingsystem.entity.*;
import com.matheusdev.bankingsystem.entity.factory.AccountFactory;
import com.matheusdev.bankingsystem.entity.factory.CardFactory;
import com.matheusdev.bankingsystem.entity.factory.UserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.Instant;

@Component
public class AccountFactoryImpl implements AccountFactory {

    @Value("${agency.number}")
    private String agencyNumber;

    @Autowired
    private UserFactory userFactory;

    @Autowired
    private CardFactory cardFactory;

    @Override
    public AccountEntity createAccount(AccountDTO accountDTO) {
        AccountEntity account = new AccountEntity();
        mapAccountDtoToAccountEntity(account, accountDTO);
        return account;
    }

    public void mapAccountDtoToAccountEntity(AccountEntity accountEntity, AccountDTO accountDTO) {
        accountEntity.setUser(userFactory.createUser(accountDTO.getUser()));
        accountEntity.setAgency(agencyNumber);
        accountEntity.setAccountNumber(generateRandomAccountNumber());
        accountEntity.setBalance(BigDecimal.ZERO);
        accountEntity.setStatus(AccountEntity.Status.ACTIVE);
        accountEntity.setOpeningDate(Instant.now());
        accountEntity.setCard(cardFactory.createCard(accountDTO.getUser()));
    }

    private String generateRandomAccountNumber() {
        SecureRandom random = new SecureRandom();
        int accountNumber = random.nextInt(100000);
        return String.valueOf(accountNumber);
    }
}
