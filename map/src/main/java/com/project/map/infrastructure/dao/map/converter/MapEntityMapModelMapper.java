package com.project.map.infrastructure.dao.map.converter;

import com.project.map.domain.entity.map.Map;
import com.project.map.infrastructure.model.MapModel;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MapEntityMapModelMapper {

//    @BeforeMapping
//    default void beforeMapping(MapModel model, @MappingTarget Map entity) {
//        model.setId(null);
//    }

    @Mapping(target = "mapName", source = "model.name")
    Map modelToEntity(MapModel model);

    @Mapping(target = "name", source = "entity.mapName")
    MapModel entityToModel(Map entity);
}
