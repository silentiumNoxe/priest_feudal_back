package com.project.map.application.map.interfaces.interactors;

import com.project.map.application.map.dto.GetMapDTO;
import com.project.map.application.map.dto.UpdateMapDTO;

public interface UpdateMapInteractor {

    GetMapDTO update(UpdateMapDTO dto);
}
