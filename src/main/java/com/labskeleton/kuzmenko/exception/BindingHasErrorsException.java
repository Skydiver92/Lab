package com.labskeleton.kuzmenko.exception;

import org.springframework.validation.BindingResult;

public class BindingHasErrorsException extends RuntimeException {
    public BindingHasErrorsException(BindingResult bindingResult, Object text, String registration) {

    }
}
