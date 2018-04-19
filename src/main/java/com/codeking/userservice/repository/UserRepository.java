package com.codeking.userservice.repository;

import com.codeking.userservice.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * CRUD user repository.
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
