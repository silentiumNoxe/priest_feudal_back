package com.priestfeudal.map.application.map.interfaces.interactors;

import com.priestfeudal.map.application.map.dto.GetMapDTO;

public interface GetMapInteractor {

    GetMapDTO getByMapId(String id);

}
