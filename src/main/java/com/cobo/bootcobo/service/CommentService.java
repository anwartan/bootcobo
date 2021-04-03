package com.cobo.bootcobo.service;

import com.cobo.bootcobo.entity.Comment;
import com.cobo.bootcobo.entity.CommunityCategory;
import com.cobo.bootcobo.model.request.CommunityCategoryReq;

import java.util.List;

public interface CommentService {
    List<Comment> getAll();
    Comment add(Comment comment);

}
