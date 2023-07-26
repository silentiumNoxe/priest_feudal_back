package com.priestfeudal.map.application.position.interfaces;

import com.priestfeudal.map.application.position.dto.GetPositionDTO;

public interface GetMapInteractor {

    GetPositionDTO getByMapId(String id);

    GetPositionDTO getByIdentifier(String identifier);
}
