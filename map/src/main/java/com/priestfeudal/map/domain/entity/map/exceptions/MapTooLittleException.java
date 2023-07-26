package com.priestfeudal.map.domain.entity.map.exceptions;

public class MapTooLittleException extends RuntimeException{

    public MapTooLittleException(int x, int y, int z, int minSize) {
        super(String.format("Map size is too little." +
                "Coordinates: x = %d, y = %d, z = %d." +
                "Minimum is %d", x, y, z, minSize)
        );
    }
}
