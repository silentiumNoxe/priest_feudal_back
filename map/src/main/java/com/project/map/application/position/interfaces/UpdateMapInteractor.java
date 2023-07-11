package com.project.map.application.position.interfaces;

import com.project.map.application.map.dto.GetMapDTO;
import com.project.map.application.position.dto.UpdatePositionDTO;

public interface UpdateMapInteractor {

    GetMapDTO update(UpdatePositionDTO dto);
}
