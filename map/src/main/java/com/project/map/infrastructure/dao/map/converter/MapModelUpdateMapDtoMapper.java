package com.project.map.infrastructure.dao.map.converter;

import com.project.map.application.map.dto.UpdateMapDTO;
import com.project.map.infrastructure.model.MapModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapModelUpdateMapDtoMapper {

    UpdateMapDTO modelToDto(MapModel model);

    MapModel dtoToModel(UpdateMapDTO dto);
}
