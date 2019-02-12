package com.labskeleton.kuzmenko.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class AccessDeniedException extends RuntimeException {

    String message;

    HttpStatus httpStatus;

    public AccessDeniedException() {
    }

    public AccessDeniedException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
