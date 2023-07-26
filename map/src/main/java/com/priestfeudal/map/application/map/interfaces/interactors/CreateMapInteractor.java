package com.priestfeudal.map.application.map.interfaces.interactors;

import com.priestfeudal.map.application.map.dto.GetMapDTO;
import com.priestfeudal.map.application.map.dto.CreateMapDTO;

public interface CreateMapInteractor {

     GetMapDTO create(CreateMapDTO dto);
}
