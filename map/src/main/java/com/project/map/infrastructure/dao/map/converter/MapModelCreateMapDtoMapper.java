package com.project.map.infrastructure.dao.map.converter;

import com.project.map.application.map.dto.CreateMapDTO;
import com.project.map.infrastructure.model.MapModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapModelCreateMapDtoMapper {

    CreateMapDTO modelToDto(MapModel model);

    MapModel dtoToModel(CreateMapDTO dto);
}
