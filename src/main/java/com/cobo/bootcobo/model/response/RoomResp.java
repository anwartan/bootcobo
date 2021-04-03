package com.cobo.bootcobo.model.response;

import java.util.ArrayList;
import java.util.List;

public class RoomResp extends BaseResponse{
    private List<String> users = new ArrayList<>();
    private String type;
    private List<String> admins = new ArrayList<>();
    private String communityId;

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getAdmins() {
        return admins;
    }

    public void setAdmins(List<String> admins) {
        this.admins = admins;
    }

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }
}
