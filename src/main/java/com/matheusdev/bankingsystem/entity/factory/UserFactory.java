package com.matheusdev.bankingsystem.entity.factory;

import com.matheusdev.bankingsystem.dto.UserDTO;
import com.matheusdev.bankingsystem.entity.UserEntity;

public interface UserFactory {
    UserEntity createUser(UserDTO createUserDTO);
}
