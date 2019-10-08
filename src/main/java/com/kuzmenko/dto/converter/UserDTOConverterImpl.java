package com.kuzmenko.dto.converter;

import com.kuzmenko.dto.CreateUserDTO;
import com.kuzmenko.dto.UserDTO;
import com.kuzmenko.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDTOConverterImpl implements UserDTOConverter {

    @Override
    public UserDTO toUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .status(user.getStatus())
                .createdAt(user.getCreatedAt())
                .lastModifiedAt(user.getLastModifiedAt())
                .build();
    }

    @Override
    public User fromCreateUserDTO(CreateUserDTO createUserDTO) {
        return User.builder()
                .email(createUserDTO.getEmail())
                .firstName(createUserDTO.getFirstName())
                .lastName(createUserDTO.getLastName())
                .password(createUserDTO.getPassword())
                .build();
    }

    @Override
    public User fromUserDTO(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.getId())
                .email(userDTO.getEmail())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .password(userDTO.getPassword())
                .status(userDTO.getStatus())
                .createdAt(userDTO.getCreatedAt())
                .lastModifiedAt(userDTO.getLastModifiedAt())
                .build();
    }
}
