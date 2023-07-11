package com.project.map.presentation.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.map.presentation.api.exceptions.ApiException;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
public class ApiResponse<T> {

    private String timestamp;
    private final Message message;
    private T data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ApiException error;

    public ApiResponse(Message message){
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.message = message;
    }

    public ApiResponse(Message message, T data){
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.message = message;
        this.data = data;
    }

    public ApiResponse(Message message, ApiException error){
        this.error = error;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.message = message;
        this.data = null;
    }

    public enum Message {
        SUCCESS,
        ERROR {
            @Override
            public boolean hasError() {
                return true;
            }
        };

        public boolean hasError() {
            return false;
        }

        };
   }
