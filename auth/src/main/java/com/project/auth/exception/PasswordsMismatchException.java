package com.project.auth.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PasswordsMismatchException extends RuntimeException{

    public PasswordsMismatchException() {
        super("Your password should be equal to repeat password.");
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    @Override
    public String getLocalizedMessage() {
        return "PASSWORDS_MISMATCH";
    }
}
