package com.labskeleton.kuzmenko.service;

import com.labskeleton.kuzmenko.dto.MessageDTO;
import com.labskeleton.kuzmenko.exception.rest.NoSuchUserException;
import com.labskeleton.kuzmenko.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    User create(User user);

    List<User> getAll();

    User getById (Integer id);

    boolean update(User user, Integer id);

    boolean deleteById(Integer id);
}
