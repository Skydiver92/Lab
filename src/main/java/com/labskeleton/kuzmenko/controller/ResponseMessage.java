package com.labskeleton.kuzmenko.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum ResponseMessage {

    USER_CREATED("User successfully created!"),
    USER_UPDATED("User successfully updated!"),
    USER_DELETED("User successfully deleted!"),
    USER_NOT_FOUND("User not found!");

    @Getter
    private String message;

}
