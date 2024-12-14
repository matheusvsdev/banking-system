package com.matheusdev.bankingsystem.entity.factory.impl;

import com.matheusdev.bankingsystem.dto.UserDTO;
import com.matheusdev.bankingsystem.entity.UserEntity;
import com.matheusdev.bankingsystem.entity.factory.UserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserFactoryImpl implements UserFactory {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserEntity createUser(UserDTO userDTO) {
        UserEntity user = new UserEntity();
        mapUserDtoToUserEntity(user, userDTO);
        return user;
    }

    public void mapUserDtoToUserEntity(UserEntity user, UserDTO userDTO) {
        user.setFullName(userDTO.getFullName());
        user.setCpf(userDTO.getCpf());
        user.setBirthDate(userDTO.getBirthDate());
        user.setSalary(userDTO.getSalary());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
    }
}
