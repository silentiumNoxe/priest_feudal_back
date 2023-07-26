package com.priestfeudal.map.infrastructure.dao.position.converter;

import com.priestfeudal.map.application.position.dto.CreatePositionDTO;
import com.priestfeudal.map.infrastructure.model.PositionModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PositionModelCreatePositionDtoMapper {

    CreatePositionDTO modelToDto(PositionModel model);

    PositionModel dtoToModel(CreatePositionDTO dto);
}
