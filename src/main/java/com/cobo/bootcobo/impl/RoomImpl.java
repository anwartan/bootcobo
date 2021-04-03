package com.cobo.bootcobo.impl;

import com.cobo.bootcobo.entity.Room;
import com.cobo.bootcobo.model.request.Room.RoomJoinQuitReq;
import com.cobo.bootcobo.model.request.Room.CreatedRoomReq;
import com.cobo.bootcobo.repo.RoomRepo;
import com.cobo.bootcobo.service.RoomService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Date;
import java.util.List;

@Service
public class RoomImpl implements RoomService {

    @Autowired
    private RoomRepo roomRepo;

    @Override
    public List<Room> getAll() {
        return roomRepo.findAll();
    }

    @Override
    public Room add(CreatedRoomReq createdRoomReq) {
        Room room = new Room();
        BeanUtils.copyProperties(createdRoomReq,room);
        room.addUser(createdRoomReq.getAdminId());
        room.addAdmin(createdRoomReq.getAdminId());
        room.setCreated_at(new Date());
        room.setUpdated_at(room.getCreated_at());
        roomRepo.save(room);
        return room;
    }

    @Override
    public Room join(RoomJoinQuitReq roomJoinQuitReq) {
        Room room = roomRepo.findById(roomJoinQuitReq.getRoomId()).orElseThrow(()->new NotFoundException("Room not found"));
        room.addUser(roomJoinQuitReq.getUserId());
        roomRepo.save(room);
        return room;
    }

    @Override
    public Boolean quit(RoomJoinQuitReq roomJoinQuitReq) {
        Room room = roomRepo.findById(roomJoinQuitReq.getRoomId()).orElseThrow(()->new NotFoundException("Room not found"));
        room.removeUser(roomJoinQuitReq.getUserId());
        roomRepo.save(room);
        return true;
    }
}
