package com.project.map.presentation.api.exceptions;


public class ApiException extends RuntimeException{

    public ApiException(final String message){
        super(message);
    }
}
