package com.cobo.bootcobo.impl;

import com.cobo.bootcobo.entity.CommunityCategory;
import com.cobo.bootcobo.model.request.CommunityCategoryReq;
import com.cobo.bootcobo.repo.CommunityCategoryRepo;
import com.cobo.bootcobo.service.CommunityCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommunityCategoryImpl implements CommunityCategoryService {

    @Autowired
    private CommunityCategoryRepo communityCategoryRepo;

    @Override
    public List<CommunityCategory> getAll() {
        return communityCategoryRepo.findAll();
    }

    @Override
    public CommunityCategory add(CommunityCategoryReq communityCategoryReq) {
        CommunityCategory communityCategory = new CommunityCategory();
        BeanUtils.copyProperties(communityCategoryReq,communityCategory);
        communityCategory.setCreated_at(new Date());
        communityCategory.setUpdated_at(communityCategory.getCreated_at());
        return communityCategoryRepo.save(communityCategory);
    }
}
