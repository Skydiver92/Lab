package com.labskeleton.kuzmenko.controller;

import com.labskeleton.kuzmenko.dto.CreateUserDTO;
import com.labskeleton.kuzmenko.dto.MessageDTO;
import com.labskeleton.kuzmenko.dto.UserDTO;
import com.labskeleton.kuzmenko.dto.converter.UserDTOConverter;
import com.labskeleton.kuzmenko.model.User;
import com.labskeleton.kuzmenko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private final UserService userService;

    private final UserDTOConverter userDTOConverter;

    @Autowired
    public UserController(UserService userService, UserDTOConverter userDTOConverter) {
        this.userService = userService;
        this.userDTOConverter = userDTOConverter;
    }


    @GetMapping("/user")
    public ResponseEntity<List<UserDTO>> getAll() {
        return new ResponseEntity<>(userService.getAll().stream()
                .map(userDTOConverter::toUserDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getBYId(@PathVariable Integer id) {
        return new ResponseEntity<>(userDTOConverter.toUserDTO(userService.getById(id)), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<MessageDTO> create(@RequestBody CreateUserDTO createUserDTO) {
        User user = userDTOConverter.fromCreateUserDTO(createUserDTO);
        userService.create(user);
        return new ResponseEntity<>(MessageDTO.builder().email(user.getEmail())
                .message(ResponseMessage.USER_CREATED.getMessage()).build(), HttpStatus.CREATED);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<MessageDTO> update(@RequestBody UserDTO newUser, @PathVariable Integer id) {
        if (userService.update(userDTOConverter.fromUserDTO(newUser), id)) {
            return new ResponseEntity<>(MessageDTO.builder().email(newUser.getEmail())
                    .message(ResponseMessage.USER_UPDATED.getMessage()).build(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(MessageDTO.builder().email(newUser.getEmail())
                    .message(ResponseMessage.USER_NOT_FOUND.getMessage()).build(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<MessageDTO> deleteById(@PathVariable Integer id) {
        String email = userService.getById(id).getEmail();
        if (userService.deleteById(id)) {
            return new ResponseEntity<>(MessageDTO.builder().email(email)
                    .message(ResponseMessage.USER_DELETED.getMessage()).build(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(MessageDTO.builder().email(email)
                    .message(ResponseMessage.USER_NOT_FOUND.toString()).build(), HttpStatus.NO_CONTENT);
        }

    }
}
