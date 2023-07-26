package com.priestfeudal.map.infrastructure.dao.map.repository;

import com.priestfeudal.map.infrastructure.model.MapModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MapDAO extends MongoRepository<MapModel, String>{

    Optional<MapModel> findById(String id);

    boolean existsById(String id);

}
