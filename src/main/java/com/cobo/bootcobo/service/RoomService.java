package com.cobo.bootcobo.service;

import com.cobo.bootcobo.entity.Room;
import com.cobo.bootcobo.model.request.Room.RoomJoinQuitReq;
import com.cobo.bootcobo.model.request.Room.CreatedRoomReq;

import java.util.List;

public interface RoomService {

    List<Room> getAll();
    Room add(CreatedRoomReq createdRoomReq);
    Room join(RoomJoinQuitReq roomJoinQuitReq);
    Boolean quit(RoomJoinQuitReq roomJoinQuitReq);
}
