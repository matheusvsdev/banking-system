package com.matheusdev.bankingsystem.tests;

import com.matheusdev.bankingsystem.entity.factory.impl.CardFactoryImpl;
import com.matheusdev.bankingsystem.dto.UserDTO;
import com.matheusdev.bankingsystem.entity.CardEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CardFactoryImplTest {

    @InjectMocks
    private CardFactoryImpl cardFactory;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateCard() {
        // Crie um objeto UserDTO
        UserDTO userDTO = new UserDTO("Nome Completo", "12345678901", LocalDate.now(), new BigDecimal(1500.00), "email@example.com", "senha");

        // Chame o método createCard
        CardEntity card = cardFactory.createCard(userDTO);

        // Verifique se o objeto CardEntity foi criado corretamente
        assertNotNull(card);
        assertEquals(userDTO.getFullName(), card.getUsername());
        assertNotNull(card.getNumber());
        assertNotNull(card.getExpirationDate());
        assertNotNull(card.getCvv());
        assertNotNull(card.getCreditLimit());
        assertEquals(BigDecimal.ZERO, card.getConsumedLimit());
        assertEquals(card.getCreditLimit(), card.getAvailableLimit());
    }

    @Test
    public void testMapUserDtoToCardEntity() {
        // Crie um objeto UserDTO
        UserDTO userDTO = new UserDTO("Nome Completo", "12345678901", LocalDate.now(), new BigDecimal(1500.00), "email@example.com", "senha");

        // Crie um objeto CardEntity
        CardEntity card = new CardEntity();

        // Chame o método mapUserDtoToCardEntity
        cardFactory.mapUserDtoToCardEntity(card, userDTO);

        // Verifique se o objeto CardEntity foi mapeado corretamente
        assertNotNull(card.getUsername());
        assertEquals(userDTO.getFullName(), card.getUsername());
        assertNotNull(card.getNumber());
        assertNotNull(card.getExpirationDate());
        assertNotNull(card.getCvv());
        assertNotNull(card.getCreditLimit());
        assertEquals(BigDecimal.ZERO, card.getConsumedLimit());
        assertEquals(card.getCreditLimit(), card.getAvailableLimit());
    }
}
