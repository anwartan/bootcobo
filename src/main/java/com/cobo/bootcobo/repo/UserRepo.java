package com.cobo.bootcobo.repo;

import com.cobo.bootcobo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends MongoRepository<User, String> {
}
