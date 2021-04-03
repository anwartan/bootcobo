package com.cobo.bootcobo.controller;

import com.cobo.bootcobo.entity.Community;
import com.cobo.bootcobo.model.enums.RoomType;
import com.cobo.bootcobo.model.request.CommunityReq;
import com.cobo.bootcobo.model.request.Room.CreatedRoomReq;
import com.cobo.bootcobo.model.response.CommunityResp;
import com.cobo.bootcobo.service.CommunityService;
import com.cobo.bootcobo.service.RoomService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "community")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @Autowired
    private RoomService roomService;

    @GetMapping(value = "all")
    public List<CommunityResp> findAll() {
        List<Community> communities = communityService.getAll();
        List<CommunityResp> communityResps = new ArrayList<>();
        for (Community item:communities) {
            CommunityResp communityResp = new CommunityResp();
            BeanUtils.copyProperties(item,communityResp);
            communityResps.add(communityResp);
        }
        return communityResps;
    }

    @GetMapping(value = "{id}")
    public CommunityResp findById(@PathVariable String id) {
        CommunityResp communityResp = new CommunityResp();

        return null;
    }

    @PostMapping(value = "add")
    public CommunityResp addCommunity(@RequestBody CommunityReq communityReq) {
        CommunityResp communityResp = new CommunityResp();
        Community community = communityService.add(communityReq);
        BeanUtils.copyProperties(community,communityResp);
        CreatedRoomReq createdRoomReq = new CreatedRoomReq();
        createdRoomReq.setType(RoomType.Private);
        createdRoomReq.setCommunityId(community.getId());
        createdRoomReq.setAdminId("0");
        roomService.add(createdRoomReq);
        return communityResp;
    }

}
