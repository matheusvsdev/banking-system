package com.matheusdev.bankingsystem.entity.factory.impl;

import com.matheusdev.bankingsystem.dto.UserDTO;
import com.matheusdev.bankingsystem.entity.CardEntity;
import com.matheusdev.bankingsystem.entity.factory.CardFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.LocalDate;

@Component
public class CardFactoryImpl implements CardFactory {

    @Override
    public CardEntity createCard(UserDTO userDTO) {
        CardEntity cardEntity = new CardEntity();
        mapUserDtoToCardEntity(cardEntity, userDTO);

        return cardEntity;
    }

    public void mapUserDtoToCardEntity(CardEntity card, UserDTO userDTO) {
        card.setUsername(userDTO.getFullName());
        card.setNumber(generateCardNumber());
        card.setExpirationDate(LocalDate.now().plusYears(5));
        card.setCvv(generateCvv());
        card.setCreditLimit(getCreditLimit(userDTO));
        card.setConsumedLimit(BigDecimal.ZERO);
        card.setAvailableLimit(card.getCreditLimit());
    }

    private String generateCardNumber() {
        SecureRandom random = new SecureRandom();
        StringBuilder cardNumber = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            cardNumber.append(random.nextInt(10));
        }
        return cardNumber.toString();
    }

    private String generateCvv() {
        SecureRandom random = new SecureRandom();
        StringBuilder cvv = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            cvv.append(random.nextInt(10));
        }
        return cvv.toString();
    }

    private BigDecimal getCreditLimit(UserDTO user) {
        if (user.getSalary().compareTo(new BigDecimal(1000.00)) >= 0) {
            return user.getSalary().multiply(new BigDecimal(0.5));
        } else {
            return BigDecimal.ZERO;
        }
    }
}
