package com.cobo.bootcobo.repo;

import com.cobo.bootcobo.entity.CommunityCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommunityCategoryRepo extends MongoRepository<CommunityCategory,String> {
}
