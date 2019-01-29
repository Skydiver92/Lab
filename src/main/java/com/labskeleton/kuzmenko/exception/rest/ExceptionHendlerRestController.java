//package com.labskeleton.kuzmenko.exception.rest;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//public class ExceptionHendlerRestController {
//    @Slf4j
//    @ControllerAdvice(basePackages = "com.itrex.skeleton.springmvc.controller.rest")
//    public class ExceptionHandlerRestController {
//
//        private static final String VALIDATION_FAILED_MSG = "Validation failed";
//
//        @ExceptionHandler(ApiException.class)
//        public ResponseEntity<ApiError> handleApiException(ApiException e) {
//            return new ResponseEntity<>(this.buildApiError(e.getHttpStatus(), e.getMessage()), e.getHttpStatus());
//        }
//
//        @ExceptionHandler(MethodArgumentNotValidException.class)
//        public ResponseEntity<ApiError> handleValidationException(MethodArgumentNotValidException ex) {
//            return new ResponseEntity<>(this.buildApiValidationError(HttpStatus.BAD_REQUEST, VALIDATION_FAILED_MSG, ex.getBindingResult()), HttpStatus.BAD_REQUEST);
//        }
//
//        @ExceptionHandler(AccessDeniedException.class)
//        public ResponseEntity<ApiError> handleAccessDeniedException(AccessDeniedException ex) {
//            return new ResponseEntity<>(this.buildApiError(HttpStatus.FORBIDDEN, ex.getMessage()), HttpStatus.FORBIDDEN);
//        }
//
//        @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
//        public ResponseEntity<ApiError> handleMediaTypeException(HttpMediaTypeNotSupportedException ex) {
//            return new ResponseEntity<>(this.buildApiError(HttpStatus.UNSUPPORTED_MEDIA_TYPE, ex.getMessage()), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
//        }
//
//        @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
//        public ResponseEntity<ApiError> handleNotSupportedMethodException(HttpRequestMethodNotSupportedException ex) {
//            return new ResponseEntity<>(this.buildApiError(HttpStatus.METHOD_NOT_ALLOWED, ex.getMessage()), HttpStatus.METHOD_NOT_ALLOWED);
//        }
//
//        @ExceptionHandler({HttpMessageNotReadableException.class})
////        public ResponseEntity<ApiError> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
//            return new ResponseEntity<>(this.buildApiError(HttpStatus.BAD_REQUEST, ex.getMessage()), HttpStatus.BAD_REQUEST);
//        }
//
//        @ExceptionHandler({Exception.class})
//        public ResponseEntity<ApiError> handleServerError(Exception ex) {
//            return new ResponseEntity<>(this.buildApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//        private ApiError buildApiError(HttpStatus httpStatus, String explanation) {
//            ApiError apiError = ApiError.builder()
//                    .uuid(UUID.randomUUID().toString())
//                    .errorCode(httpStatus.value())
//                    .errorStatus(httpStatus.getReasonPhrase())
//                    .explanation(explanation)
//                    .timestamp(LocalDateTime.now())
//                    .build();
//            log.error(apiError.toString());
//            return apiError;
//        }
//
//        private ApiError buildApiValidationError(HttpStatus httpStatus, String explanation, BindingResult bindingResult) {
//            List<ValidationError> validationErrors = bindingResult.getGlobalErrors().stream()
//                    .map(error -> new ValidationError(error.getObjectName(), Arrays.asList(error.getDefaultMessage())))
//                    .collect(Collectors.toList());
//            validationErrors.addAll(bindingResult.getFieldErrors().stream()
//                    .map(error -> new ValidationError(error.getField(), Arrays.asList(error.getDefaultMessage()))).collect(Collectors.toList()));
//            ApiError apiError = ApiError.builder()
//                    .uuid(UUID.randomUUID().toString())
//                    .errorCode(httpStatus.value())
//                    .errorStatus(httpStatus.getReasonPhrase())
//                    .explanation(explanation)
//                    .timestamp(LocalDateTime.now())
//                    .validationErrors(validationErrors)
//                    .build();
//            log.error(apiError.toString());
//            return apiError;
//        }
//    }
//}
