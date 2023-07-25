package com.priestfeudal.map.application.position.interfaces;

import com.priestfeudal.map.application.map.dto.GetMapDTO;
import com.priestfeudal.map.application.position.dto.CreatePositionDTO;

public interface CreatePositionInteractor {

    GetMapDTO create(CreatePositionDTO dto);
}
