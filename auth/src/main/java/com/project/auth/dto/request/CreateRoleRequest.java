package com.project.auth.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.auth.entity.Role.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateRoleRequest {

    private int id;

    @JsonProperty(value = "role_type")
    private RoleType roleType;
}
