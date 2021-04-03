package com.cobo.bootcobo.controller;

import com.cobo.bootcobo.entity.Posting;
import com.cobo.bootcobo.model.request.PostingReq;
import com.cobo.bootcobo.model.response.PostingResp;
import com.cobo.bootcobo.service.PostingService;
import com.cobo.bootcobo.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "posting")
public class PostingController {

    @Autowired
    private PostingService postingService;

    @Autowired
    private StorageService storageService;

    @GetMapping(value = "all")
    public List<PostingResp> findAll() {
        List<Posting> postings = postingService.getAll();
        List<PostingResp> postingResps = new ArrayList<>();
        for (Posting item:postings) {
            PostingResp postingResp = new PostingResp();
            postingResp.setImage_url(storageService.getRootLocation() +item.getImage_url());
            postingResp.setDescription(item.getDescription());
            postingResp.setCreated_at(item.getCreated_at());
            postingResp.setUpdated_at(item.getUpdated_at());
            postingResp.setId(item.getId());
            postingResp.setComments(item.getComments());
            postingResp.setLikes(item.getLikes());
            postingResps.add(postingResp);
        }
        return postingResps;
    }

    @PostMapping(value = "upload")
    public PostingResp addCommunity(@RequestParam("image_url") MultipartFile multipartFile,@RequestParam("description") String description) {
        storageService.init();
        String fullName = new Date().getTime()+"-"+multipartFile.getOriginalFilename();
        storageService.store(multipartFile,fullName);
        PostingReq postingReq = new PostingReq();
        postingReq.setImage_url(fullName);
        postingReq.setDescription(description);
        PostingResp postingResp = new PostingResp();
        Posting posting = postingService.create(postingReq);
        postingResp.setImage_url(storageService.getRootLocation() +posting.getImage_url());
        postingResp.setDescription(posting.getDescription());
        postingResp.setCreated_at(posting.getCreated_at());
        postingResp.setUpdated_at(posting.getUpdated_at());
        postingResp.setId(posting.getId());
        return postingResp;
    }
}
