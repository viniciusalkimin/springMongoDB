package com.alkimin.springMongoDB.repository;

import com.alkimin.springMongoDB.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    public User findByName(String name);
}
