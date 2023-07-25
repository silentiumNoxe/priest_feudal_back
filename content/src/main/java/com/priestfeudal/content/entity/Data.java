package com.priestfeudal.content.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Map;
import java.util.UUID;

@Document("data")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Data {

    @Id
    private UUID id;

    @Field("properties")
    private Map<String, Object> properties;
}
