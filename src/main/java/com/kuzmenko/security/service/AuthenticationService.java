package com.kuzmenko.security.service;

import com.kuzmenko.dto.LoginDTO;

public interface AuthenticationService {

    LoginDTO login(String header) throws Exception;

    LoginDTO refresh(String header);
}