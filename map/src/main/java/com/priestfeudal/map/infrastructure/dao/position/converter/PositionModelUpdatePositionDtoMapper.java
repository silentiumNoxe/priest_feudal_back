package com.priestfeudal.map.infrastructure.dao.position.converter;

import com.priestfeudal.map.application.position.dto.UpdatePositionDTO;
import com.priestfeudal.map.infrastructure.model.PositionModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PositionModelUpdatePositionDtoMapper {

    UpdatePositionDTO modelToDto(PositionModel model);

    PositionModel dtoToModel(UpdatePositionDTO dto);
}
