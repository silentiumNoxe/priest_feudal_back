package com.priestfeudal.map.application.position.interfaces;

import com.priestfeudal.map.application.map.dto.GetMapDTO;
import com.priestfeudal.map.application.position.dto.UpdatePositionDTO;

public interface UpdateMapInteractor {

    GetMapDTO update(UpdatePositionDTO dto);
}
