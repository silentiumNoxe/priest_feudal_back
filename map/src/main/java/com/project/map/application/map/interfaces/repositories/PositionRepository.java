package com.project.map.application.map.interfaces.repositories;

import com.project.map.application.position.dto.CreatePositionDTO;
import com.project.map.application.position.dto.GetPositionDTO;
import com.project.map.application.position.dto.UpdatePositionDTO;

import java.util.Optional;

public interface PositionRepository {

    public void createPosition(CreatePositionDTO dto);

    public Optional<GetPositionDTO> getByModelIdentifierAndMapId(String modelIdentifier, String mapId);

    public boolean exists(String modelIdentifier, Integer x, Integer y, Integer z, String mapId);

    public void updatePosition(UpdatePositionDTO dto);

}
