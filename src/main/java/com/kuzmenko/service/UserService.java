package com.kuzmenko.service;

import com.kuzmenko.exception.UserNotFoundException;
import com.kuzmenko.model.User;

import java.util.List;

public interface UserService {

    User create(User user);

    List<User> getAll();

    User getById(Integer id) throws UserNotFoundException;

    User getByEmail(String email);

    void update(User user, Integer id);

    boolean deleteById(Integer id);


}
