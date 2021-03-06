package com.kuzmenko.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class ApiException {

    String message;

    Integer status;

    LocalDateTime timestamp;

}
