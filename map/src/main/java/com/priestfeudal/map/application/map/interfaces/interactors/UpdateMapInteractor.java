package com.priestfeudal.map.application.map.interfaces.interactors;

import com.priestfeudal.map.application.map.dto.UpdateMapDTO;
import com.priestfeudal.map.application.map.dto.GetMapDTO;

public interface UpdateMapInteractor {

    GetMapDTO update(UpdateMapDTO dto);
}
