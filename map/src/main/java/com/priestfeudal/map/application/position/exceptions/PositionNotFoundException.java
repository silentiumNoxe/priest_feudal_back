package com.priestfeudal.map.application.position.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PositionNotFoundException extends RuntimeException{

    public PositionNotFoundException(final String message){
        super(message);
    }
}
