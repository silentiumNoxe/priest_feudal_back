package com.priestfeudal.auth.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.priestfeudal.auth.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CreateUserRequest {

    @JsonProperty(value = "username", required = true)
    private String username;

    @JsonProperty(value = "email", required = true)
    private String email;

    @JsonProperty(value = "password", required = true)
    private String password;

    @JsonProperty(value = "repeat_password", required = true)
    private String repeatPassword;

    @JsonProperty(value = "roles")
    private Set<Role> roles;

}
