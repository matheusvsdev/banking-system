package com.matheusdev.bankingsystem.entity.factory.impl;

import com.matheusdev.bankingsystem.dto.CreateAccountDTO;
import com.matheusdev.bankingsystem.dto.CreateUserDTO;
import com.matheusdev.bankingsystem.entity.*;
import com.matheusdev.bankingsystem.entity.factory.AccountFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Random;

@Component
public class AccountFactoryImpl implements AccountFactory {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AccountEntity createAccount(CreateAccountDTO dto) {

        AccountEntity account = new AccountEntity();
        account.setUser(createUser(dto.getUser()));
        account.setAccountNumber(generateRandomAccountNumber());
        account.setBalance(BigDecimal.ZERO);
        account.setStatus(AccountEntity.Status.ACTIVE);
        account.setOpeningDate(Instant.now());
        account.setCard(generateCard(dto.getUser()));

        return account;
    }

    private UserEntity createUser(CreateUserDTO userDTO) {
        UserEntity user = new UserEntity();
        user.setFullName(userDTO.getFullName());
        user.setCpf(userDTO.getCpf());
        user.setBirthDate(userDTO.getBirthDate());
        user.setSalary(userDTO.getSalary());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return user;
    }

    private String generateRandomAccountNumber() {
        Random random = new Random();
        int accountNumber = random.nextInt(10000);
        return String.valueOf(accountNumber);
    }

    private CardEntity generateCard(CreateUserDTO user) {
        if (checkIncome(user)) {
            CardEntity cardEntity = new CardEntity();
            cardEntity.setUsername(user.getFullName());
            cardEntity.setNumber(generateCardNumber());
            cardEntity.setExpirationDate(LocalDate.now().plusYears(5));
            cardEntity.setCvv(generateCvv());
            cardEntity.setCreditLimit(user.getSalary().multiply(new BigDecimal(2)));
            cardEntity.setConsumedLimit(BigDecimal.ZERO);
            cardEntity.setAvailableLimit(cardEntity.getCreditLimit());

            return cardEntity;
        }

        CardEntity cardEntity = new CardEntity();
        cardEntity.setUsername(user.getFullName());
        cardEntity.setNumber(generateCardNumber());
        cardEntity.setExpirationDate(LocalDate.now().plusYears(5));
        cardEntity.setCvv(generateCvv());
        cardEntity.setCreditLimit(BigDecimal.ZERO);
        cardEntity.setConsumedLimit(BigDecimal.ZERO);
        cardEntity.setAvailableLimit(cardEntity.getCreditLimit());

        return cardEntity;
    }

    private boolean checkIncome(CreateUserDTO user) {
        return user.getSalary().compareTo(new BigDecimal(1000.00)) >= 0;
    }

    private String generateCardNumber() {
        Random random = new Random();
        StringBuilder cardNumber = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            cardNumber.append(random.nextInt(10));
        }
        return cardNumber.toString();
    }

    private String generateCvv() {
        Random random = new Random();
        StringBuilder cvv = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            cvv.append(random.nextInt(10));
        }
        return cvv.toString();
    }
}
