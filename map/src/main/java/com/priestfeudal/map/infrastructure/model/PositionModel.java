package com.priestfeudal.map.infrastructure.model;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@With
@Document("position")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PositionModel {

    @Indexed(unique = true)
    @Field("model_identifier")
    private String modelIdentifier;

    @Field("coordinate_x")
    private int x;

    @Field("coordinate_y")
    private int y;

    @Field("coordinate_z")
    private int z;

    @Field("map_id")
    private String mapId;

}
