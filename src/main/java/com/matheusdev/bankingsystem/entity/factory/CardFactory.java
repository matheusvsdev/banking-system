package com.matheusdev.bankingsystem.entity.factory;

import com.matheusdev.bankingsystem.dto.UserDTO;
import com.matheusdev.bankingsystem.entity.CardEntity;

public interface CardFactory {
    CardEntity createCard(UserDTO userDTO);
}
