package com.priestfeudal.map.domain.entity.map.methods;

import com.priestfeudal.map.domain.entity.map.Map;
import com.priestfeudal.map.domain.entity.map.exceptions.MapTooBigException;

public interface MapCreate {

    default Map create(String mapName, int x, int y, int z) {
        if (x > Map.MAXSIZE || y > Map.MAXSIZE || z > Map.MAXSIZE) {
            throw new MapTooBigException(x, y, z, Map.MAXSIZE);
        }
        if (x < Map.MINSIZE || y < Map.MINSIZE || z < Map.MINSIZE) {
           throw new MapTooBigException(x, y, z, Map.MINSIZE);
        }

        return new Map(mapName, x, y, z);
    }
}
