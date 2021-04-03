package com.cobo.bootcobo.controller;

import com.cobo.bootcobo.entity.Room;
import com.cobo.bootcobo.model.request.Room.RoomJoinQuitReq;
import com.cobo.bootcobo.model.response.RoomResp;
import com.cobo.bootcobo.service.RoomService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class RoomController {
    @Autowired
    private RoomService roomService;

    @MessageMapping("/joinRoom")
    @SendTo("/broker/room")
    public RoomResp join(RoomJoinQuitReq roomJoinQuitReq){
        Room room = roomService.join(roomJoinQuitReq);
        RoomResp roomResp = new RoomResp();
        BeanUtils.copyProperties(room,roomResp);
        return roomResp;
    }

    @MessageMapping("/quitRoom")
    @SendTo("/broker/room")
    public RoomResp quit(RoomJoinQuitReq roomJoinQuitReq){
        Boolean status = roomService.quit(roomJoinQuitReq);
        RoomResp roomResp = new RoomResp();
        return roomResp;
    }

}
