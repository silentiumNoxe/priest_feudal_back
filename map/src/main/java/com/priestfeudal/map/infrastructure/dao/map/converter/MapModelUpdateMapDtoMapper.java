package com.priestfeudal.map.infrastructure.dao.map.converter;

import com.priestfeudal.map.application.map.dto.UpdateMapDTO;
import com.priestfeudal.map.infrastructure.model.MapModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapModelUpdateMapDtoMapper {

    UpdateMapDTO modelToDto(MapModel model);

    MapModel dtoToModel(UpdateMapDTO dto);
}
