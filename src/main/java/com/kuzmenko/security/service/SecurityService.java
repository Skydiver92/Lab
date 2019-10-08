package com.kuzmenko.security.service;

public interface SecurityService {

    String findLoggedInUser();

    void autoLogin  (String username, String password);
}
