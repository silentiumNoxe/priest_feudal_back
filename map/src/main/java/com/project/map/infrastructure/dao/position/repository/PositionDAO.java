package com.project.map.infrastructure.dao.position.repository;

import com.project.map.infrastructure.model.PositionModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

//@Repository
public interface PositionDAO extends MongoRepository<PositionModel, String> {

    Optional<PositionModel> findByModelIdentifierAndMapId(String modelIdentifier, String MapId);

    boolean existsByModelIdentifierAndXAndYAndZAndMapId(String modelIdentifier, Integer x, Integer y, Integer z, String mapId);
}
