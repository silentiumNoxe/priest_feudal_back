package com.priestfeudal.map.application.map.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MapNotFoundException extends RuntimeException{

    public MapNotFoundException(final String message){
        super(message);
    }

}
