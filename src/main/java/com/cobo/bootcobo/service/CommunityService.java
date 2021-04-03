package com.cobo.bootcobo.service;

import com.cobo.bootcobo.entity.Community;
import com.cobo.bootcobo.model.request.CommunityReq;
import org.json.simple.JSONArray;

import java.util.List;

public interface CommunityService {
    List<Community> getAll();
    Community add(CommunityReq communityReq);
    Community getMenuById(String id);

}
