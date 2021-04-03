package com.cobo.bootcobo.service;

import com.cobo.bootcobo.entity.CommunityCategory;
import com.cobo.bootcobo.model.request.CommunityCategoryReq;
import com.cobo.bootcobo.model.request.CommunityReq;

import java.util.List;

public interface CommunityCategoryService {

    List<CommunityCategory> getAll();
    CommunityCategory add(CommunityCategoryReq communityCategoryReq);

}
