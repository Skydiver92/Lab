//package com.labskeleton.kuzmenko.security;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Component;
//
//@Component
//public class JwtAuthenticationProvider implements AuthenticationProvider {
//    private final JwtSettings jwtSettings;
//
//    @Autowired
//    public JwtAuthenticationProvider(JwtSettings jwtSettings) {
//        this.jwtSettings = jwtSettings;
//    }
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        RawAccessJwtToken rawAccessToken = (RawAccessJwtToken) authentication.getCredentials();
//
//        Jws<Claims> jwsClaims = rawAccessToken.parseClaims(jwtSettings.getTokenSigningKey());
//        String subject = jwsClaims.getBody().getSubject();
//        List<String> scopes = jwsClaims.getBody().get("scopes", List.class);
//        List<GrantedAuthority> authorities = scopes.stream()
//                .map(authority -> new SimpleGrantedAuthority(authority))
//                .collect(Collectors.toList());
//
//        UserContext context = UserContext.create(subject, authorities);
//
//        return new JwtAuthenticationToken(context, context.getAuthorities());
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
//    }
//}
