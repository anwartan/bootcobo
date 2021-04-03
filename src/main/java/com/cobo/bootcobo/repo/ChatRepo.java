package com.cobo.bootcobo.repo;

import com.cobo.bootcobo.entity.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatRepo  extends MongoRepository<Chat,String> {
}
