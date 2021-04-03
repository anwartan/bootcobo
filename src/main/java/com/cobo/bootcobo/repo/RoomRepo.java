package com.cobo.bootcobo.repo;

import com.cobo.bootcobo.entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepo extends MongoRepository<Room,String> {
}
