package com.labskeleton.kuzmenko.security.filter;

import com.labskeleton.kuzmenko.exception.InvalidTokenException;
import com.labskeleton.kuzmenko.model.Constants;
import com.labskeleton.kuzmenko.model.User;
import com.labskeleton.kuzmenko.security.JwtAuthentication;
import io.jsonwebtoken.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Component
public class JwtAuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException, AuthenticationException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        this.tryAuthenticate(req);
        filterChain.doFilter(request, response);
    }



    private void tryAuthenticate(HttpServletRequest req) throws InvalidTokenException {
        String authHeaderValue = req.getHeader(HttpHeaders.AUTHORIZATION);
        String token = this.extractToken(authHeaderValue);
        if (token != null) {
            Authentication authentication = this.extract(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }

    private String extractToken(String authHeaderContent) {
        if (authHeaderContent == null) {
            return null;
        } else {
            String[] array = authHeaderContent.split("\\s");
            return this.containsBearerToken(array) ? array[1] : null;
        }
    }

    private boolean containsBearerToken(String[] array) {
        return array.length == 2 && array[0].equals(Constants.BEARER);
    }

    public Authentication extract(String token) throws InvalidTokenException  {
        try {
            Claims claims = Jwts.parser().setSigningKey(Constants.key).parseClaimsJws(token).getBody();

            Integer userId = claims.get(Constants.TOKEN_USER_ID_CLAIM, Integer.class);
            String rolesAsString = claims.get(Constants.TOKEN_ROLES_CLAIM, String.class);
            if (userId != null) {
                List<GrantedAuthority> authorityList = rolesAsString == null ? Collections.EMPTY_LIST : AuthorityUtils.commaSeparatedStringToAuthorityList(rolesAsString);

                //TODO: Research UsernamePasswordAuthenticationToken
                /*Authentication auth = new UsernamePasswordAuthenticationToken(userId, null, authorityList);
                auth.setAuthenticated(true);*/

                return JwtAuthentication.builder()
                        .user(User.builder().id(userId).build())
                        .grantedAuthorities(authorityList)
                        .authenticated(true).build();
            } else {
                return null;
            }
        } catch (SignatureException e) {
            throw new InvalidTokenException("Invalid JW token!", HttpStatus.UNAUTHORIZED);
        } catch (ExpiredJwtException e) {
            throw new InvalidTokenException("Token expired!", HttpStatus.BAD_REQUEST);
        } catch (MalformedJwtException e) {
            throw new InvalidTokenException("Invalid JW token", HttpStatus.BAD_REQUEST);

//            throw new RuntimeException("Exception");
        }


    }

    @Override
    public void destroy() {

    }
}

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtTokenGenerator jwtTokenGenerator;
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        try {
//            User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
//
//            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        return null;
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
//        User user = (User) authResult.getPrincipal();
//        String token = jwtTokenGenerator.generateAccessToken(user);
//        response.addHeader(HttpHeaders.AUTHORIZATION, Constants.BEARER + token);
//
//
//    }
//}