package com.project.map.domain.entity.map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Map {

    public static final Integer MAXSIZE = 25000;
    public static final Integer MINSIZE = 5000;

    private String mapName;

    private int lengthX;

    private int lengthY;

    private int lengthZ;

}
