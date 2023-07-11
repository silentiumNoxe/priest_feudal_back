package com.project.map.infrastructure.dao.position.converter;

import com.project.map.application.position.dto.UpdatePositionDTO;
import com.project.map.infrastructure.model.PositionModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PositionModelUpdatePositionDtoMapper {

    UpdatePositionDTO modelToDto(PositionModel model);

    PositionModel dtoToModel(UpdatePositionDTO dto);
}
