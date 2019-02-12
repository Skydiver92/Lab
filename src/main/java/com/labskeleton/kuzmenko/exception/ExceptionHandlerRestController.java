package com.labskeleton.kuzmenko.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;


@ControllerAdvice//(basePackages = "com.labskeleton.kuzmenko.controller")
public class ExceptionHandlerRestController {

//    private static final String VALIDATION_FAILED_MSG = "Validation failed";

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiException> handleUserNotFoundException(UserNotFoundException e) {
        return new ResponseEntity<>(new ApiException(e.getMessage(), e.getHttpStatus().value(), LocalDateTime.now()), e.getHttpStatus());

    }

//    @ExceptionHandler(AccessDeniedException.class)
//    public ResponseEntity<ApiException> handleAccessDeniedException(AccessDeniedException e) {
//        return new ResponseEntity<>(new ApiException(e.getMessage(), e.getHttpStatus().value(), LocalDateTime.now()), e.getHttpStatus());
//    }

//    @ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Invalid JW token!")
//    @ExceptionHandler(InvalidTokenException.class)
//    public void handleInvalidTokenException(InvalidTokenException e) {
//
//    }





//    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "File not found!")
//    @ExceptionHandler(ApiException.class)
//    public ResponseEntity<ApiException> handleApiException(ApiException e) {
//        return new ResponseEntity<>(this.buildApiError(e.getHttpStatus(), e.getMessage()), e.getHttpStatus());
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ApiException> handleValidationException(MethodArgumentNotValidException ex) {
//        return new ResponseEntity<>(this.buildApiValidationError(HttpStatus.BAD_REQUEST, VALIDATION_FAILED_MSG, ex.getBindingResult()), HttpStatus.BAD_REQUEST);
//    }
//

//
//    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
//    public ResponseEntity<ApiException> handleMediaTypeException(HttpMediaTypeNotSupportedException ex) {
//        return new ResponseEntity<>(this.buildApiError(HttpStatus.UNSUPPORTED_MEDIA_TYPE, ex.getMessage()), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
//    }
//
//    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
//    public ResponseEntity<ApiException> handleNotSupportedMethodException(HttpRequestMethodNotSupportedException ex) {
//        return new ResponseEntity<>(this.buildApiError(HttpStatus.METHOD_NOT_ALLOWED, ex.getMessage()), HttpStatus.METHOD_NOT_ALLOWED);
//    }
//
//    @ExceptionHandler({HttpMessageNotReadableException.class})
////        public ResponseEntity<ApiException> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
//            return new ResponseEntity<>(this.
//
//    buildApiError(HttpStatus.BAD_REQUEST, ex.getMessage()),HttpStatus.BAD_REQUEST);
//}
//
//    @ExceptionHandler({Exception.class})
//    public ResponseEntity<ApiException> handleServerError(Exception ex) {
//        return new ResponseEntity<>(this.buildApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    private ApiException buildApiError(HttpStatus httpStatus, String explanation) {
//        ApiException apiError = ApiException.builder()
//                .uuid(UUID.randomUUID().toString())
//                .errorCode(httpStatus.value())
//                .errorStatus(httpStatus.getReasonPhrase())
//                .explanation(explanation)
//                .timestamp(LocalDateTime.now())
//                .build();
//        log.error(apiError.toString());
//        return apiError;
//    }
//
//    private ApiException buildApiValidationError(HttpStatus httpStatus, String explanation, BindingResult bindingResult) {
//        List<ValidationError> validationErrors = bindingResult.getGlobalErrors().stream()
//                .map(error -> new ValidationError(error.getObjectName(), Arrays.asList(error.getDefaultMessage())))
//                .collect(Collectors.toList());
//        validationErrors.addAll(bindingResult.getFieldErrors().stream()
//                .map(error -> new ValidationError(error.getField(), Arrays.asList(error.getDefaultMessage()))).collect(Collectors.toList()));
//        ApiException apiError = ApiException.builder()
//                .uuid(UUID.randomUUID().toString())
//                .errorCode(httpStatus.value())
//                .errorStatus(httpStatus.getReasonPhrase())
//                .explanation(explanation)
//                .timestamp(LocalDateTime.now())
//                .validationErrors(validationErrors)
//                .build();
//        log.error(apiError.toString());
//        return apiError;
//    }
}

