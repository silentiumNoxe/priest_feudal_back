package com.project.auth.repository;

import com.project.auth.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends MongoRepository<User, UUID> {

    User findByEmail(String email);

    boolean existsByEmail(String email);
}
