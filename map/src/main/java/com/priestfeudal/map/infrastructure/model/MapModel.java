package com.priestfeudal.map.infrastructure.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Objects;

@With
@Document("map")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MapModel {

    @Id
    private String id;

    @Field("length_x")
    private int lengthX;

    @Field("length_y")
    private int lengthY;

    @Field("length_z")
    private int lengthZ;

    @Version
    @Field("version")
    private Long version;

    @Field("name")
    @Indexed(unique = true)
    private String name;

    @Field("created_at")
    private LocalDateTime createdAt;

    @Field("updated_at")
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapModel mapModel = (MapModel) o;
        return id.equals(mapModel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
