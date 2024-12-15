package com.matheusdev.bankingsystem.service;

import com.matheusdev.bankingsystem.entity.CardEntity;
import com.matheusdev.bankingsystem.entity.UserEntity;
import com.matheusdev.bankingsystem.entity.factory.AccountFactory;
import com.matheusdev.bankingsystem.repository.AccountRepository;
import com.matheusdev.bankingsystem.service.impl.AccountServiceImpl;
import com.matheusdev.bankingsystem.dto.AccountDTO;
import com.matheusdev.bankingsystem.dto.ResponseAccountDTO;
import com.matheusdev.bankingsystem.entity.AccountEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class AccountServiceImplTest {

    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    private AccountFactory accountFactory;

    @Mock
    private AccountRepository accountRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateAccount() {
        // Crie um objeto AccountDTO
        AccountDTO accountDTO = new AccountDTO();

        // Crie um objeto AccountEntity
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(1L);
        accountEntity.setUser(new UserEntity());
        accountEntity.setCard(new CardEntity());
        accountEntity.setBalance(BigDecimal.ZERO);
        accountEntity.setStatus(AccountEntity.Status.ACTIVE);

        // Defina o comportamento do accountFactory e accountRepository
        when(accountFactory.createAccount(any())).thenReturn(accountEntity);
        when(accountRepository.save(any())).thenReturn(accountEntity);

        // Chame o método createAccount
        ResponseAccountDTO account = accountService.createAccount(accountDTO);

        // Verifique se o objeto ResponseAccountDTO foi criado corretamente
        assertNotNull(account);
        assertEquals(accountEntity.getId(), account.getId());
        assertEquals(accountEntity.getAgency(), account.getAgency());
        assertEquals(accountEntity.getAccountNumber(), account.getAccountNumber());
        assertEquals(accountEntity.getBalance(), account.getBalance());
        assertEquals(accountEntity.getOpeningDate(), account.getOpeningDate());
        assertEquals(accountEntity.getStatus(), account.getStatus());
        assertEquals(accountEntity.getUser().getId(), account.getUser().getId());
    }
}
