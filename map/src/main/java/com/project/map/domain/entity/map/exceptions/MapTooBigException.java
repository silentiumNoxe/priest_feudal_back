package com.project.map.domain.entity.map.exceptions;

public class MapTooBigException extends RuntimeException{

    public MapTooBigException(int x, int y, int z, int maxSize) {
        super(String.format("Map size is too big." +
                "Coordinates: x = %d, y = %d, z = %d." +
                "Maximum is %d", x, y, z, maxSize)
        );
    }
}
