package com.labskeleton.kuzmenko.controller.rest;

import com.labskeleton.kuzmenko.dto.LoginDTO;
import com.labskeleton.kuzmenko.model.Constants;
import com.labskeleton.kuzmenko.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


@RestController
@RequestMapping("/api")
public class AuthenticationController {

    private static final String HEADER_DELIMITER = " ";

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/login")
    public ResponseEntity<LoginDTO> login(HttpServletRequest request) throws Exception {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authHeader != null && !authHeader.isEmpty() && authHeader.startsWith(Constants.BASIC_AUTH)) {
            String encodedHeader = authHeader.split(HEADER_DELIMITER)[1];
            byte[] headerDecoded = Base64.getDecoder().decode(encodedHeader);
            String decodedHeader = new String(headerDecoded, StandardCharsets.UTF_8);
            LoginDTO loginDTO = authenticationService.login(decodedHeader);
            return new ResponseEntity<>(loginDTO, HttpStatus.OK);
        } else {
            throw new Exception();
        }

    }
    //throw new ApiException(ApiException.Message.INVALID_AUTH.getText(), HttpStatus.BAD_REQUEST);


    @RequestMapping(value = "/refresh")
    public ResponseEntity<LoginDTO> refresh(HttpServletRequest request) {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        LoginDTO loginDTO = null;
        if (authHeader != null && !authHeader.isEmpty() && authHeader.startsWith(Constants.BEARER)) {
            loginDTO = authenticationService.refresh(authHeader.split(HEADER_DELIMITER)[1]);


        }
        return new ResponseEntity<>(loginDTO, HttpStatus.OK);
        //throw new ApiException(ApiException.Message.INVALID_AUTH.getText(), HttpStatus.BAD_REQUEST);
    }

}
