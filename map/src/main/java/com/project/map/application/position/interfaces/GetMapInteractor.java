package com.project.map.application.position.interfaces;

import com.project.map.application.position.dto.GetPositionDTO;

public interface GetMapInteractor {

    GetPositionDTO getByMapId(String id);

    GetPositionDTO getByIdentifier(String identifier);
}
