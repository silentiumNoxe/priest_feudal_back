package com.priestfeudal.map.application.map.interfaces.repositories;

import com.priestfeudal.map.application.map.dto.GetMapDTO;
import com.priestfeudal.map.domain.entity.map.Map;

import java.util.Optional;

public interface MapRepository {

    GetMapDTO createMap(Map map);

    Optional<GetMapDTO> getByMapId(String id);

    GetMapDTO updateMap(Map map);

    void deleteByMapId(String id);

}
