package com.project.map.infrastructure.dao.position.converter;

import com.project.map.application.position.dto.GetPositionDTO;
import com.project.map.infrastructure.model.PositionModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PositionModelGetPositionDtoMapper {

    GetPositionDTO modelToDto(PositionModel model);

}
