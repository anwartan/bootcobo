package com.cobo.bootcobo.model.request.Room;

import com.cobo.bootcobo.model.enums.RoomType;

import java.util.ArrayList;
import java.util.List;

public class CreatedRoomReq {
    private RoomType type;
    private String adminId ;
    private String communityId;

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }
}
