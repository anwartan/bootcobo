package com.cobo.bootcobo.repo;

import com.cobo.bootcobo.entity.Posting;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostingRepo extends MongoRepository<Posting,String> {

}
