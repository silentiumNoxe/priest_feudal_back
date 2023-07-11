package com.project.map.infrastructure.dao.position.converter;

import com.project.map.application.position.dto.CreatePositionDTO;
import com.project.map.infrastructure.model.PositionModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PositionModelCreatePositionDtoMapper {

    CreatePositionDTO modelToDto(PositionModel model);

    PositionModel dtoToModel(CreatePositionDTO dto);
}
