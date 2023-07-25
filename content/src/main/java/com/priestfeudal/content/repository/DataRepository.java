package com.priestfeudal.content.repository;

import com.priestfeudal.content.entity.Data;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface DataRepository extends MongoRepository<Data, UUID> {
}
