package com.project.map.application.map.interfaces.interactors;

import com.project.map.application.map.dto.CreateMapDTO;
import com.project.map.application.map.dto.GetMapDTO;

public interface CreateMapInteractor {

     GetMapDTO create(CreateMapDTO dto);
}
