package com.labskeleton.kuzmenko.service;

import com.labskeleton.kuzmenko.exception.UserNotFoundException;
import com.labskeleton.kuzmenko.model.User;

import java.util.List;

public interface UserService {

    User create(User user);

    List<User> getAll();

    User getById(Integer id) throws UserNotFoundException;

    User getByEmail(String email);

    void update(User user, Integer id);

    boolean deleteById(Integer id);


}
