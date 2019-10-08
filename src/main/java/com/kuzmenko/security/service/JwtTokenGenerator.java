package com.kuzmenko.security.service;

import com.kuzmenko.model.Constants;
import com.kuzmenko.model.Role;
import com.kuzmenko.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Data
@AllArgsConstructor
public class JwtTokenGenerator implements JwtToken {


    @Override
    public String generateAccessToken(User user) {
        List<String> roles = user.getRoles().stream().map(Role::getAuthority).collect(Collectors.toList());
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim(Constants.TOKEN_ROLES_CLAIM, String.join(",", roles))
                .claim(Constants.TOKEN_USER_ID_CLAIM, user.getId())
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plusSeconds(60)))
                .signWith(SignatureAlgorithm.HS512, Constants.key)
                .compact();
    }

    @Override
    public String generateRefreshToken(User user) {
        List<String> roles = user.getRoles().stream().map(Role::getAuthority).collect(Collectors.toList());
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim(Constants.TOKEN_ROLES_CLAIM, String.join(",", roles))
                .claim(Constants.TOKEN_USER_ID_CLAIM, user.getId())
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plusSeconds(60000)))
                .signWith(SignatureAlgorithm.HS512, Constants.key)
                .compact();
    }

    @Override
    public String parseEmailFromToken(String token) {
        Claims claims = Jwts
                .parser()
                .setSigningKey(Constants.key)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}
