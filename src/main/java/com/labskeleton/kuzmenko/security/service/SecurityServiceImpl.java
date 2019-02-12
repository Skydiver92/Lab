//package com.labskeleton.kuzmenko.security.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Component;
//
//@Component
//public class SecurityServiceImpl implements SecurityService {
//
//    @Autowired
//    AuthenticationManager authenticationManager;
//    @Autowired
//    UserDetailsService userDetailsService;
////
////    @Autowired
////    public SecurityServiceImpl(AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
////        this.authenticationManager = authenticationManager;
////        this.userDetailsService = userDetailsService;
////    }
//
//    @Override
//    public String findLoggedInUser() {
//        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
//        if (userDetails instanceof UserDetails) {
//            return ((UserDetails) userDetails).getUsername();
//        }
//        return null;
//    }
//
//    @Bean
//    @Override
//    public void autoLogin(String username, String password) {
//        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//        UsernamePasswordAuthenticationToken authenticationToken =
//                new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
//        authenticationManager.authenticate(authenticationToken);
//        if (authenticationToken.isAuthenticated()) {
//            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//        }
//
//    }
//}
