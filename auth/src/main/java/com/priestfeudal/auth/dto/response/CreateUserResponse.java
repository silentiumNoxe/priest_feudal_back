package com.priestfeudal.auth.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.priestfeudal.auth.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUserResponse {

    @JsonProperty(value = "result")
    private CreateUserResult result;

    @JsonProperty(value = "user")
    private UserDTO userDTO;

    public enum CreateUserResult {

        USER_CREATE_SUCCESS("User was created successfully"),
        USER_CREATE_ERROR("Error creating user");

        private String value;

        private CreateUserResult(String value) {
           this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
