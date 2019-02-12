package com.labskeleton.kuzmenko.security;


import com.labskeleton.kuzmenko.exception.ApiException;
import com.labskeleton.kuzmenko.exception.UserNotFoundException;
import com.labskeleton.kuzmenko.model.User;
import com.labskeleton.kuzmenko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.getByEmail(email);
        if (user == null) {
            throw new UserNotFoundException("User not found", HttpStatus.NOT_FOUND);
        }
        List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
        return new SecurityUserDetails(user.getId(), user.getEmail(), user.getPassword(), authorities);
    }
}