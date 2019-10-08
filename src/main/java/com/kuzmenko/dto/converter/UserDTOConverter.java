package com.kuzmenko.dto.converter;

import com.kuzmenko.dto.CreateUserDTO;
import com.kuzmenko.dto.UserDTO;
import com.kuzmenko.model.User;

public interface UserDTOConverter {

    UserDTO toUserDTO(User user);

    User fromUserDTO(UserDTO userDTO);

    User fromCreateUserDTO(CreateUserDTO createUserDTO);

}
