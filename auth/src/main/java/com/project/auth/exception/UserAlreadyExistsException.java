package com.project.auth.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException(String email) {
        super(String.format("User with email = %s already exists", email));
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    @Override
    public String getLocalizedMessage() {
        return "USER_ALREADY_EXISTS";
    }
}
