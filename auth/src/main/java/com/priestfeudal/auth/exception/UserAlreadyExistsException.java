package com.priestfeudal.auth.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException(String email) {
        super(String.format("User with email = %s already exists", email));
    }

}
