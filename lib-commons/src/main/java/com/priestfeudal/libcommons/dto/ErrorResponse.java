package com.priestfeudal.libcommons.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    @JsonProperty(value = "request_id", required = true)
    private UUID requestId;

    @JsonProperty(value = "error_code", required = true, defaultValue = "0")
    private ErrorCode errorCode;

    @JsonProperty(value = "error_reason", required = true, defaultValue = "Server-side error")
    private String errorReason;

    @JsonProperty(value = "timestamp", required = true)
    private String timestamp;

    public ErrorResponse(UUID requestId, ErrorCode errorCode, String errorReason) {
        this.requestId = requestId;
        this.errorCode = errorCode;
        this.errorReason = errorReason;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }
}
