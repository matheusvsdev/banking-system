package com.matheusdev.bankingsystem.tests;

import com.matheusdev.bankingsystem.entity.factory.impl.UserFactoryImpl;
import com.matheusdev.bankingsystem.dto.UserDTO;
import com.matheusdev.bankingsystem.entity.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserFactoryImplTest {

    @InjectMocks
    private UserFactoryImpl userFactory;

    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateUser() {
        // Crie um objeto UserDTO
        UserDTO userDTO = new UserDTO("Nome Completo", "12345678901", LocalDate.now(), new BigDecimal(1500.00), "email@example.com", "senha");

        // Defina o comportamento do passwordEncoder
        when(passwordEncoder.encode(any())).thenReturn("senha-criptografada");

        // Chame o método createUser
        UserEntity user = userFactory.createUser(userDTO);

        // Verifique se o objeto UserEntity foi criado corretamente
        assertNotNull(user);
        assertEquals(userDTO.getFullName(), user.getFullName());
        assertEquals(userDTO.getCpf(), user.getCpf());
        assertEquals(userDTO.getBirthDate(), user.getBirthDate());
        assertEquals(userDTO.getSalary(), user.getSalary());
        assertEquals(userDTO.getEmail(), user.getEmail());
        assertEquals("senha-criptografada", user.getPassword());
    }

    @Test
    public void testMapUserDtoToUserEntity() {
        // Crie um objeto UserDTO
        UserDTO userDTO = new UserDTO("Nome Completo", "12345678901", LocalDate.now(), new BigDecimal(1500.00), "email@example.com", "senha");

        // Crie um objeto UserEntity
        UserEntity user = new UserEntity();

        // Defina o comportamento do passwordEncoder
        when(passwordEncoder.encode(any())).thenReturn("senha-criptografada");

        // Chame o método mapUserDtoToUserEntity
        userFactory.mapUserDtoToUserEntity(user, userDTO);

        // Verifique se o objeto UserEntity foi mapeado corretamente
        assertNotNull(user.getFullName());
        assertEquals(userDTO.getFullName(), user.getFullName());
        assertEquals(userDTO.getCpf(), user.getCpf());
        assertEquals(userDTO.getBirthDate(), user.getBirthDate());
        assertEquals(userDTO.getSalary(), user.getSalary());
        assertEquals(userDTO.getEmail(), user.getEmail());
        assertEquals("senha-criptografada", user.getPassword());
    }
}
