package com.matheusdev.bankingsystem.entity.factory;

import com.matheusdev.bankingsystem.dto.CreateAccountDTO;
import com.matheusdev.bankingsystem.dto.CreateUserDTO;
import com.matheusdev.bankingsystem.entity.Account;
import com.matheusdev.bankingsystem.entity.User;
import com.matheusdev.bankingsystem.entity.enums.AccountStatus;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Random;

@Component
public class AccountFactoryImpl implements AccountFactory {

    @Override
    public Account createAccount(CreateAccountDTO dto) {
        Account account = new Account();
        account.setUser(createUser(dto.getUser()));
        account.setAccountNumber(generateRandomAccountNumber());
        account.setAccountType(dto.getAccountType());
        account.setAccountStatus(AccountStatus.ACTIVE);
        account.setOpeningDate(Instant.now());
        account.setBalance(BigDecimal.ZERO);
        return account;
    }

    private User createUser(CreateUserDTO createUserDTO) {
        User user = new User();
        user.setFirstName(createUserDTO.getFirstName());
        user.setLastName(createUserDTO.getLastName());
        user.setBirthDate(createUserDTO.getBirthDate());
        user.setEmail(createUserDTO.getEmail());
        user.setPassword(createUserDTO.getPassword());
        return user;
    }

    private String generateRandomAccountNumber() {
        Random random = new Random();
        int accountNumber = random.nextInt(10000);
        return String.valueOf(accountNumber);
    }
}
