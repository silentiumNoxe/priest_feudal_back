package com.project.map.application.map.interfaces.interactors;

import com.project.map.application.map.dto.GetMapDTO;

import java.util.UUID;

public interface GetMapInteractor {

    GetMapDTO getByMapId(String id);

}
