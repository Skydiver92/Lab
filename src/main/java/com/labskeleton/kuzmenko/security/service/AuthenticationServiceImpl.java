package com.labskeleton.kuzmenko.security.service;

import com.labskeleton.kuzmenko.dto.LoginDTO;
import com.labskeleton.kuzmenko.model.Constants;
import com.labskeleton.kuzmenko.model.User;
import com.labskeleton.kuzmenko.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    UserService userService;

    @Autowired
    JwtTokenGenerator jwtTokenGenerator;


    @Override
    public LoginDTO login(String header) throws Exception {
        String email = header.split(":")[0];
        User user = userService.getByEmail(email);
        String password = header.split(":")[1];
        if (!password.equals(user.getPassword())) {
            throw new Exception("Wrong password");
        }
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setAccessToken(jwtTokenGenerator.generateAccessToken(user));
        loginDTO.setRefreshToken(jwtTokenGenerator.generateRefreshToken(user));
        return loginDTO;
    }

    @Override
    public LoginDTO refresh(String headerToken) {
        String email = null;
        try {
            Claims jws = Jwts.parser()
                    .setSigningKey(Constants.key)
                    .parseClaimsJws(headerToken)
                    .getBody();
            email = jws.getSubject();
        } catch (SignatureException e) {
            e.printStackTrace();
        }
        User user = userService.getByEmail(email);
        LoginDTO loginDTO = new LoginDTO();
        if (email != null && email.equals(user.getEmail())) {
            loginDTO.setAccessToken(jwtTokenGenerator.generateAccessToken(user));
            loginDTO.setRefreshToken(jwtTokenGenerator.generateRefreshToken(user));
        }

        return loginDTO;
    }
}
