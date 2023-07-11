package com.project.map.application.position.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdatePositionDTO {

    @JsonProperty(value = "model_identifier", required = true)
    private String modelIdentifier;

    @JsonProperty(value = "coordinate_x", required = true)
    private int x;

    @JsonProperty(value = "coordinate_y", required = true)
    private int y;

    @JsonProperty(value = "coordinate_z", required = true)
    private int z;

    @JsonProperty(value = "map_id", required = true)
    private String mapId;
}
