package com.cobo.bootcobo.repo;

import com.cobo.bootcobo.entity.Community;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommunityRepo extends MongoRepository<Community,String> {
}
