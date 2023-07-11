package com.project.map.application.map.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateMapDTO {

    @JsonProperty(value = "coordinate_x", required = true)
    private int x;

    @JsonProperty(value = "coordinate_y", required = true)
    private int y;

    @JsonProperty(value = "coordinate_z", required = true)
    private int z;

    @JsonProperty(value = "name", required = true)
    private String name;
}
