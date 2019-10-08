//package com.kuzmenko.security;
//
//import com.kuzmenko.model.Constants;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
//@Data
//public class JwtAutorizationFilter extends BasicAuthenticationFilter {
//
//
//    public JwtAutorizationFilter(AuthenticationManager authenticationManager) {
//        super(authenticationManager);
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//       String header = request.getHeader("Authorization");
//
//
//
//       super.doFilterInternal(request, response, chain);
//    }
//
//    @Override
//    protected AuthenticationEntryPoint getAuthenticationEntryPoint() {
//        return super.getAuthenticationEntryPoint();
//    }
//}
