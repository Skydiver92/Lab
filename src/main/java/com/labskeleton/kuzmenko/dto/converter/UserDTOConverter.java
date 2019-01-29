package com.labskeleton.kuzmenko.dto.converter;

import com.labskeleton.kuzmenko.dto.CreateUserDTO;
import com.labskeleton.kuzmenko.dto.UserDTO;
import com.labskeleton.kuzmenko.model.User;

public interface UserDTOConverter {

    UserDTO toUserDTO(User user);

    User fromUserDTO(UserDTO userDTO);

    User fromCreateUserDTO(CreateUserDTO createUserDTO);

}
