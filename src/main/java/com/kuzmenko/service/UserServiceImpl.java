package com.kuzmenko.service;

import com.kuzmenko.dao.UserRepository;
import com.kuzmenko.exception.UserNotFoundException;
import com.kuzmenko.model.Role;
import com.kuzmenko.model.Status;
import com.kuzmenko.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User create(User user) {
        user.setStatus(Status.ACTIVE);
        user.setRoles(Collections.singleton(new Role("USER")));
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Integer id) {
        if (userRepository.findById(id).isPresent()) {
            return userRepository.findById(id).get();
        } else {
            throw new UserNotFoundException(UserNotFoundException.NO_SUCH_USER, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public User getByEmail(String email) {
        if (userRepository.findUserByEmail(email) != null) {
            return userRepository.findUserByEmail(email);
        } else {
            throw new UserNotFoundException(UserNotFoundException.NO_SUCH_USER, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void update(User newUser, Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException(UserNotFoundException.NO_SUCH_USER, HttpStatus.NOT_FOUND);
        }
        newUser.setId(id);
        userRepository.save(newUser);
    }

    @Override
    public boolean deleteById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent())
            throw new UserNotFoundException(UserNotFoundException.NO_SUCH_USER, HttpStatus.NOT_FOUND);
        userRepository.deleteById(id);
        return true;
    }

}
