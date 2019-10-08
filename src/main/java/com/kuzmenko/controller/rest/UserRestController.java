package com.kuzmenko.controller.rest;

import com.kuzmenko.controller.ResponseMessage;
import com.kuzmenko.dto.CreateUserDTO;
import com.kuzmenko.dto.MessageDTO;
import com.kuzmenko.dto.UserDTO;
import com.kuzmenko.dto.converter.UserDTOConverter;
import com.kuzmenko.model.User;
import com.kuzmenko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ITRex Group
 */

@RestController
@RequestMapping("/user")
public class UserRestController {

    private final UserService userService;

    private final UserDTOConverter userDTOConverter;

    @Autowired
    public UserRestController(UserService userService, UserDTOConverter userDTOConverter) {
        this.userService = userService;
        this.userDTOConverter = userDTOConverter;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll() {
        return new ResponseEntity<>(userService.getAll().stream()
                .map(userDTOConverter::toUserDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getBYId(@PathVariable Integer id) {
        return new ResponseEntity<>(userDTOConverter.toUserDTO(userService.getById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MessageDTO> create(@RequestBody CreateUserDTO createUserDTO) {
        User user = userDTOConverter.fromCreateUserDTO(createUserDTO);
        userService.create(user);
        return new ResponseEntity<>(MessageDTO.builder().email(user.getEmail())
                .message(ResponseMessage.USER_CREATED.getMessage()).build(), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<MessageDTO> update(@RequestBody UserDTO newUser, @PathVariable Integer id) {
        userService.update(userDTOConverter.fromUserDTO(newUser), id);
        return new ResponseEntity<>(MessageDTO.builder().email(newUser.getEmail())
                .message(ResponseMessage.USER_UPDATED.getMessage()).build(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<MessageDTO> deleteById(@PathVariable Integer id) {
        String email = userService.getById(id).getEmail();
        userService.deleteById(id);
        return new ResponseEntity<>(MessageDTO.builder().email(email)
                .message(ResponseMessage.USER_DELETED.getMessage()).build(), HttpStatus.OK);
    }

}
