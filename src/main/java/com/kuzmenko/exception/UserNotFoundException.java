package com.kuzmenko.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

//@ResponseStatus(value = HttpStatus.NOT_FOUND)
//@SuppressWarnings("serial")
@Data
public class UserNotFoundException extends RuntimeException {

    public static final String NO_SUCH_USER = "Such user not found!";

    String message;

    HttpStatus httpStatus;

    public UserNotFoundException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }


}
