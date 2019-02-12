package com.labskeleton.kuzmenko.security.service;

import com.labskeleton.kuzmenko.model.User;

public interface JwtToken {

    String generateAccessToken(User user);

    String generateRefreshToken(User user);

    String parseEmailFromToken(String token);
}
