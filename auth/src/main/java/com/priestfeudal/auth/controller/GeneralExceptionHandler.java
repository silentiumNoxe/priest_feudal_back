package com.priestfeudal.auth.controller;

import com.priestfeudal.auth.exception.PasswordsMismatchException;
import com.priestfeudal.auth.exception.UserAlreadyExistsException;
import com.priestfeudal.auth.exception.UserNotFoundException;
import com.priestfeudal.libcommons.dto.ErrorCode;
import com.priestfeudal.libcommons.utils.RequestIdHolder;
import com.priestfeudal.libcommons.dto.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class GeneralExceptionHandler {

    private final RequestIdHolder requestIdHolder;

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handle(final Exception e){
        if(e.getMessage() == null){
            e.printStackTrace();
        }
        log.debug("Exception: {}, time: {}", e.getMessage(), LocalDateTime.now());
        return new ErrorResponse(null, ErrorCode.INTERNAL_ERROR, e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PasswordsMismatchException.class)
    public ErrorResponse handler(final PasswordsMismatchException e) {
        e.printStackTrace();
        return new ErrorResponse(requestIdHolder.mustGet(), ErrorCode.BAD_REQUEST, ErrorCode.BAD_REQUEST.getReason());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ErrorResponse handler(final UserAlreadyExistsException e) {
        e.printStackTrace();
        return new ErrorResponse(requestIdHolder.mustGet(), ErrorCode.BAD_REQUEST, ErrorCode.BAD_REQUEST.getReason());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorResponse handler(final UserNotFoundException e) {
        e.printStackTrace();
        return new ErrorResponse(requestIdHolder.mustGet(), ErrorCode.NOT_FOUND, ErrorCode.NOT_FOUND.getReason());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthenticationException.class)
    public ErrorResponse handler(final AuthenticationException e) {
        e.printStackTrace();
        return new ErrorResponse(requestIdHolder.mustGet(), ErrorCode.ACCESS_DENIED, ErrorCode.ACCESS_DENIED.getReason());
    }
}
