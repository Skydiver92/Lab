package com.labskeleton.kuzmenko.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;


@Data
public class InvalidTokenException extends AuthenticationException {

    String message;

    HttpStatus httpStatus;

    public InvalidTokenException(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

}
