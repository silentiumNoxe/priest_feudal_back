package com.priestfeudal.map.infrastructure.dao.position.converter;

import com.priestfeudal.map.application.position.dto.GetPositionDTO;
import com.priestfeudal.map.infrastructure.model.PositionModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PositionModelGetPositionDtoMapper {

    GetPositionDTO modelToDto(PositionModel model);

}
