package com.priestfeudal.auth.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PasswordsMismatchException extends RuntimeException{

    public PasswordsMismatchException() {
        super("Your password should be equal to repeat password.");
    }

}
