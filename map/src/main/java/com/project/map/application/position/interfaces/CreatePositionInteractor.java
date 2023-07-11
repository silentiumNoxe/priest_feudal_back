package com.project.map.application.position.interfaces;

import com.project.map.application.map.dto.GetMapDTO;
import com.project.map.application.position.dto.CreatePositionDTO;

public interface CreatePositionInteractor {

    GetMapDTO create(CreatePositionDTO dto);
}
