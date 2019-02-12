package com.labskeleton.kuzmenko.security.service;

import com.labskeleton.kuzmenko.dto.LoginDTO;

public interface AuthenticationService {

    LoginDTO login(String header) throws Exception;

    LoginDTO refresh(String header);
}