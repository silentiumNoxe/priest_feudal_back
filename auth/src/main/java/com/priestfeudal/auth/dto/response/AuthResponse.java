package com.priestfeudal.auth.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.priestfeudal.auth.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthResponse {

    @JsonProperty(value = "auth_result", required = true)
    private AuthResult authResult;

    @JsonProperty(value = "jwt_token")
    private String jwtToken;

    @JsonProperty(value = "user")
    private UserDTO userDTO;

    public enum AuthResult {

        AUTH_SUCCESS("Authentication performed with success."),
        AUTH_FAILED("Authentication failed");

        private final String value;

        private AuthResult(String value) {
            this.value = value;
        }

        private String getValue() {
            return value;
        }
    }
}
