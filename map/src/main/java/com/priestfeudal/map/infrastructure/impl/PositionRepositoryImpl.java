package com.priestfeudal.map.infrastructure.impl;

import com.priestfeudal.map.application.map.interfaces.repositories.PositionRepository;
import com.priestfeudal.map.application.position.dto.CreatePositionDTO;
import com.priestfeudal.map.application.position.dto.GetPositionDTO;
import com.priestfeudal.map.application.position.dto.UpdatePositionDTO;
import com.priestfeudal.map.application.position.exceptions.PositionNotFoundException;
import com.priestfeudal.map.infrastructure.dao.position.converter.PositionModelCreatePositionDtoMapper;
import com.priestfeudal.map.infrastructure.dao.position.converter.PositionModelGetPositionDtoMapper;
import com.priestfeudal.map.infrastructure.dao.position.converter.PositionModelUpdatePositionDtoMapper;
import com.priestfeudal.map.infrastructure.dao.position.repository.PositionDAO;
import com.priestfeudal.map.infrastructure.model.PositionModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PositionRepositoryImpl implements PositionRepository {

    private final PositionDAO repository;
    private final PositionModelCreatePositionDtoMapper createPositionDtoMapper;
    private final PositionModelGetPositionDtoMapper getPositionDtoMapper;
    private final PositionModelUpdatePositionDtoMapper updatePositionDtoMapper;

    @Override
    public void createPosition(CreatePositionDTO dto) {
       repository.save(createPositionDtoMapper.dtoToModel(dto));
    }

    @Override
    public Optional<GetPositionDTO> getByModelIdentifierAndMapId(String modelIdentifier, String mapId) {
        return Optional.of(getPositionDtoMapper.modelToDto(repository.findByModelIdentifierAndMapId(modelIdentifier, mapId).get()));
    }

    @Override
    public boolean exists(String modelIdentifier, Integer x, Integer y, Integer z, String mapId) {
        return repository.existsByModelIdentifierAndXAndYAndZAndMapId(modelIdentifier, x, y, z, mapId);
    }

    @Override
    public void updatePosition(UpdatePositionDTO dto) {
        PositionModel position = repository.findByModelIdentifierAndMapId(dto.getModelIdentifier(), dto.getMapId())
                .orElseThrow(() -> new PositionNotFoundException("position"));
        repository.save(position
                .withX(dto.getX())
                .withY(dto.getY())
                .withZ(dto.getZ())
        );
    }
}
