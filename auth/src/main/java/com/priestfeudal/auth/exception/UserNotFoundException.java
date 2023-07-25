package com.priestfeudal.auth.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String email) {
        super(String.format("User with email = %s wasn't found", email));
    }

}
