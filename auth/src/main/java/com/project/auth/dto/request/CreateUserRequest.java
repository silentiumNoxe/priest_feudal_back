package com.project.auth.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.auth.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CreateUserRequest {

    @JsonProperty(required = true)
    private String username;

    @JsonProperty(required = true)
    private String email;

    @JsonProperty(required = true)
    private String password;

    @JsonProperty(value = "repeat_password", required = true)
    private String repeatPassword;

    private Set<Role> roles;

}
