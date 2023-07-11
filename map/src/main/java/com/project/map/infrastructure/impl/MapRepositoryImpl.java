package com.project.map.infrastructure.impl;

import com.project.map.application.map.dto.GetMapDTO;
import com.project.map.application.map.exceptions.MapNotFoundException;
import com.project.map.application.map.interfaces.repositories.MapRepository;
import com.project.map.domain.entity.map.Map;
import com.project.map.infrastructure.dao.map.converter.MapEntityMapModelMapper;
import com.project.map.infrastructure.dao.map.converter.MapModelGetMapDtoMapper;
import com.project.map.infrastructure.dao.map.repository.MapDAO;
import com.project.map.infrastructure.model.MapModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class MapRepositoryImpl implements MapRepository {

    private final MapDAO repository;
    private final MapEntityMapModelMapper mapEntityModelMapper;
    private final MapModelGetMapDtoMapper getMapDtoMapper;

    @Override
    public GetMapDTO createMap(Map entity) {
        MapModel newModel = mapEntityModelMapper.entityToModel(entity);
       MapModel model = repository
               .insert(newModel
                       .withCreatedAt(LocalDateTime.now())
                       .withUpdatedAt(LocalDateTime.now())
               );
       return getMapDtoMapper.modelToDto(model);
    }

    @Override
    public Optional<GetMapDTO> getByMapId(String id) {
        return Optional.of(getMapDtoMapper.modelToDto(repository.findById(id).get()));
    }

    @Override
    public GetMapDTO updateMap(Map entity) {
         MapModel maybeModel = repository.findById("232").orElseThrow(
                 () -> new MapNotFoundException("map")
         );
         MapModel model = repository.save(maybeModel
                 .withUpdatedAt(LocalDateTime.now())
                 .withName(entity.getMapName())
                 .withLengthX(entity.getLengthX())
                 .withLengthY(entity.getLengthY())
                 .withLengthZ(entity.getLengthZ())
         );
         return getMapDtoMapper.modelToDto(model);
    }

    @Override
    public void deleteByMapId(String id) {
        repository.deleteById(id);
    }

}
