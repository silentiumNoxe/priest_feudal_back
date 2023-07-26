package com.priestfeudal.auth.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Role {

    private Integer id;

    private RoleType type;

    public enum RoleType {
        USER_SYSTEM,
        USER_PLAYER;
    }
}
