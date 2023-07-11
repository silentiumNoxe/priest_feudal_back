package com.project.map.application.map.interfaces.repositories;

import com.project.map.application.map.dto.GetMapDTO;
import com.project.map.domain.entity.map.Map;

import java.util.Optional;
import java.util.UUID;

public interface MapRepository {

    GetMapDTO createMap(Map map);

    Optional<GetMapDTO> getByMapId(String id);

    GetMapDTO updateMap(Map map);

    void deleteByMapId(String id);

}
