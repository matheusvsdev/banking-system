package com.matheusdev.bankingsystem.tests;

import com.matheusdev.bankingsystem.entity.CardEntity;
import com.matheusdev.bankingsystem.entity.UserEntity;
import com.matheusdev.bankingsystem.entity.factory.CardFactory;
import com.matheusdev.bankingsystem.entity.factory.UserFactory;
import com.matheusdev.bankingsystem.entity.factory.impl.AccountFactoryImpl;
import com.matheusdev.bankingsystem.dto.AccountDTO;
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

public class AccountFactoryImplTest {

    @InjectMocks
    private AccountFactoryImpl accountFactory;

    @Mock
    private UserFactory userFactory;

    @Mock
    private CardFactory cardFactory;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateAccount() {
        // Crie um objeto AccountDTO
        AccountDTO accountDTO = new AccountDTO();

        // Defina o comportamento do userFactory e cardFactory
        when(userFactory.createUser(any())).thenReturn(new UserEntity());
        when(cardFactory.createCard(any())).thenReturn(new CardEntity());

        // Chame o método createAccount
        AccountEntity account = accountFactory.createAccount(accountDTO);

        // Verifique se o objeto AccountEntity foi criado corretamente
        assertNotNull(account);
        assertNotNull(account.getUser());
        assertNotNull(account.getCard());
        assertEquals(BigDecimal.ZERO, account.getBalance());
        assertEquals(AccountEntity.Status.ACTIVE, account.getStatus());
    }

    @Test
    public void testMapAccountDtoToAccountEntity() {
        // Crie um objeto AccountDTO
        AccountDTO accountDTO = new AccountDTO();

        // Crie um objeto AccountEntity
        AccountEntity account = new AccountEntity();

        // Defina o comportamento do userFactory e cardFactory
        when(userFactory.createUser(any())).thenReturn(new UserEntity());
        when(cardFactory.createCard(any())).thenReturn(new CardEntity());

        // Chame o método mapAccountDtoToAccountEntity
        accountFactory.mapAccountDtoToAccountEntity(account, accountDTO);

        // Verifique se o objeto AccountEntity foi mapeado corretamente
        assertNotNull(account.getUser());
        assertNotNull(account.getCard());
        assertEquals(BigDecimal.ZERO, account.getBalance());
        assertEquals(AccountEntity.Status.ACTIVE, account.getStatus());
    }
}
