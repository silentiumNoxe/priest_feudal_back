package com.priestfeudal.map.infrastructure.dao.map.converter;

import com.priestfeudal.map.infrastructure.model.MapModel;
import com.priestfeudal.map.application.map.dto.CreateMapDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapModelCreateMapDtoMapper {

    CreateMapDTO modelToDto(MapModel model);

    MapModel dtoToModel(CreateMapDTO dto);
}
