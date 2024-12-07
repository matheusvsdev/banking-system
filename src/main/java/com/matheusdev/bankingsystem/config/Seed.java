package com.matheusdev.bankingsystem.config;

import com.matheusdev.bankingsystem.dto.CreateAccountDTO;
import com.matheusdev.bankingsystem.dto.ResponseAccountDTO;
import com.matheusdev.bankingsystem.entity.Account;
import com.matheusdev.bankingsystem.entity.User;
import com.matheusdev.bankingsystem.entity.enums.AccountStatus;
import com.matheusdev.bankingsystem.entity.enums.AccountType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Random;

@Component
public class Seed implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Random random = new Random();
        int accountNumber1 = random.nextInt(10000);
        int agency1 = random.nextInt(10000);

        int accountNumber2 = random.nextInt(10000);
        int agency2 = random.nextInt(10000);

        User user1 = new User(null,
                "Testando",
                "Java",
                LocalDate.of(1997, 1, 1),
                "testando@example.com",
                "1234567");

        User user2 = new User(null,
                "Testando 2",
                "Spring",
                LocalDate.of(1980, 2, 20),
                "testando2@example.com",
                "1234567");

        entityManager.persist(user1);
        entityManager.persist(user2);


        CreateAccountDTO createAccount1DTO = new CreateAccountDTO(AccountType.PERSONAL, user1);
        CreateAccountDTO createAccount2DTO = new CreateAccountDTO(AccountType.BUSINESS, user2);


        Account account1 = new Account();
        account1.setAccountType(createAccount1DTO.getAccountType());
        account1.setOpeningDate(Instant.now());
        account1.setAccountStatus(AccountStatus.ACTIVE);
        account1.setAgency(String.valueOf(agency1));
        account1.setAccountNumber(String.valueOf(accountNumber1));
        account1.setUser(createAccount1DTO.getUser());

        Account account2 = new Account();
        account2.setAccountType(createAccount2DTO.getAccountType());
        account2.setOpeningDate(Instant.now());
        account2.setAccountStatus(AccountStatus.ACTIVE);
        account2.setAgency(String.valueOf(agency2));
        account2.setAccountNumber(String.valueOf(accountNumber2));
        account2.setUser(createAccount2DTO.getUser());

        entityManager.persist(account1);
        entityManager.persist(account2);

        ResponseAccountDTO responseAccount1DTO = new ResponseAccountDTO(account1);
        ResponseAccountDTO responseAccount2DTO = new ResponseAccountDTO(account2);

        System.out.println("\n");
        System.out.printf(responseAccount1DTO.toString());
        System.out.println("\n");
        System.out.printf(responseAccount2DTO.toString());

    }
}
