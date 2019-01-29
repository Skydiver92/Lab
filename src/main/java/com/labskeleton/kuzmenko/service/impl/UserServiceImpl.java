package com.labskeleton.kuzmenko.service.impl;

import com.labskeleton.kuzmenko.model.Role;
import com.labskeleton.kuzmenko.model.RoleList;
import com.labskeleton.kuzmenko.model.Status;
import com.labskeleton.kuzmenko.model.User;
import com.labskeleton.kuzmenko.repository.UserRepository;
import com.labskeleton.kuzmenko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
        user.setRoles(Collections.singleton(new Role(RoleList.USER)));
        return userRepository.save(user);
    }


    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }


    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).orElseGet(null);
    }


    @Override
    public boolean update(User newUser, Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent())
            return false;

        newUser.setId(id);
        userRepository.save(newUser);
        return true;
    }


    @Override
    public boolean deleteById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent())
            return false;
        userRepository.deleteById(id);
        return true;


    }
}
