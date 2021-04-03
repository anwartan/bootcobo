package com.cobo.bootcobo.service;

import com.cobo.bootcobo.entity.Comment;
import com.cobo.bootcobo.entity.Like;
import com.cobo.bootcobo.entity.Posting;
import com.cobo.bootcobo.model.request.CommentReq;
import com.cobo.bootcobo.model.request.LikeReq;
import com.cobo.bootcobo.model.request.PostingReq;

import java.util.List;

public interface PostingService {
    List<Posting> getAll();
    Posting create(PostingReq postingReq);
    Comment addComment(CommentReq commentReq);
    Like setLike (LikeReq likeReq);
}
