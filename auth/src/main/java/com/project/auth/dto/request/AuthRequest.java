package com.project.auth.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthRequest {

    @JsonProperty(value = "email", required = true)
    private String email;

    @JsonProperty(value = "password", required = true)
    private String password;
}
