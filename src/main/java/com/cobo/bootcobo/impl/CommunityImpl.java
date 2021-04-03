package com.cobo.bootcobo.impl;

import com.cobo.bootcobo.entity.Community;
import com.cobo.bootcobo.model.request.CommunityReq;
import com.cobo.bootcobo.repo.CommunityRepo;
import com.cobo.bootcobo.service.CommunityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommunityImpl implements CommunityService {

    @Autowired
    private CommunityRepo communityRepo;

    @Override
    public List<Community> getAll() {
        return communityRepo.findAll();
    }

    @Override
    public Community add(CommunityReq communityReq) {

        Community community = new Community();
        BeanUtils.copyProperties(communityReq,community);
        community.setCreated_at(new Date());
        community.setUpdated_at(community.getCreated_at());
        return communityRepo.save(community);
    }

    @Override
    public Community getMenuById(String id) {
        return null;
    }
}
