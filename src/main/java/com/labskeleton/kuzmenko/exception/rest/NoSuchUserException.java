package com.labskeleton.kuzmenko.exception.rest;

import org.springframework.http.HttpStatus;

public class NoSuchUserException extends Exception {

    HttpStatus status;

    public NoSuchUserException(String message) {
        super(message);
    }

    public NoSuchUserException(HttpStatus status) {
        super();
        this.status = status;
    }
}
