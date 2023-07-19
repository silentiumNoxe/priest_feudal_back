package com.project.auth.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("role")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Role {

    @Id
    private Integer id;

    @Field("type")
    @Indexed(unique = true)
    private RoleType type;

    public enum RoleType {

        USER_SYSTEM,
        USER_PLAYER;

//        private String type;
//
//        public RoleType(String type) {
//            this.type = type;
//        }
//
//        public String getValue() {
//            return type;
//        }
    }
}
