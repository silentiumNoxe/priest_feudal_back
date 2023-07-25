package com.priestfeudal.map.domain.entity.map.methods;

import com.priestfeudal.map.domain.entity.map.Map;
import com.priestfeudal.map.domain.entity.map.exceptions.MapTooBigException;

import java.util.UUID;

public interface MapUpdate {

    default Map update(UUID id, String name, int x, int y, int z) {
        if (x > Map.MAXSIZE || y > Map.MAXSIZE || z > Map.MAXSIZE) {
            throw new MapTooBigException(x, y, z, Map.MAXSIZE);
        }
        if (x < Map.MINSIZE || y < Map.MINSIZE || z < Map.MINSIZE) {
            throw new MapTooBigException(x, y, z, Map.MINSIZE);
        }

        return new Map(name, x, y, z);
    }
}
