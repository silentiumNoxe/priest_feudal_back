package com.priestfeudal.map.infrastructure.dao.map.converter;

import com.priestfeudal.map.domain.entity.map.Map;
import com.priestfeudal.map.infrastructure.model.MapModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

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
