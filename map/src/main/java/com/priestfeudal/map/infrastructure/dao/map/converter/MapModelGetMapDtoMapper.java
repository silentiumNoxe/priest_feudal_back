package com.priestfeudal.map.infrastructure.dao.map.converter;

import com.priestfeudal.map.infrastructure.model.MapModel;
import com.priestfeudal.map.application.map.dto.GetMapDTO;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface MapModelGetMapDtoMapper {

    @BeforeMapping
    default void beforeMappingMethod(MapModel model, @MappingTarget GetMapDTO dto) {
        dto.setId(model.getId());
       dto.setCreatedAt(model.getCreatedAt().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
       dto.setUpdatedAt(model.getUpdatedAt().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }

    @Mapping(target = "x", source = "model.lengthX")
    @Mapping(target = "y", source = "model.lengthY")
    @Mapping(target = "z", source = "model.lengthZ")
    GetMapDTO modelToDto(MapModel model);

}
