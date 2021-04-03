package com.cobo.bootcobo.controller;

import com.cobo.bootcobo.entity.CommunityCategory;
import com.cobo.bootcobo.model.request.CommunityCategoryReq;
import com.cobo.bootcobo.model.response.CommunityCategoryResp;
import com.cobo.bootcobo.model.response.CommunityResp;
import com.cobo.bootcobo.service.CommunityCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.ContentCachingRequestWrapper;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "communityCategory")
public class CommunityCategoryController {
    @Autowired
    private CommunityCategoryService communityCategoryService;

    @GetMapping(value = "all")
    public List<CommunityCategoryResp> findAll() {
        List<CommunityCategory> communityCategories = communityCategoryService.getAll();
        List<CommunityCategoryResp> communityResps = new ArrayList<>();
        for (CommunityCategory item:communityCategories) {
            CommunityCategoryResp communityResp = new CommunityCategoryResp();
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
    public CommunityCategoryResp addCommunity(@RequestBody CommunityCategoryReq communityCategoryReq) {
        CommunityCategoryResp communityCategoryResp = new CommunityCategoryResp();
        CommunityCategory community = communityCategoryService.add(communityCategoryReq);
        BeanUtils.copyProperties(community,communityCategoryResp);

        return communityCategoryResp;
    }
}
