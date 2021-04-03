package com.cobo.bootcobo.controller;

import com.cobo.bootcobo.entity.Comment;
import com.cobo.bootcobo.entity.Like;
import com.cobo.bootcobo.model.request.CommentReq;
import com.cobo.bootcobo.model.request.LikeReq;
import com.cobo.bootcobo.model.response.CommentResp;
import com.cobo.bootcobo.model.response.LikeResp;
import com.cobo.bootcobo.service.PostingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class CommentController {

    @Autowired
    private PostingService postingService;

    @MessageMapping("/sendComment")
    @SendTo("/broker/comment")
    public CommentResp comment(CommentReq commentReq){
        CommentResp commentResp = new CommentResp();
        Comment comment = postingService.addComment(commentReq);
        BeanUtils.copyProperties(comment,commentResp);

        return commentResp;
    }

    @MessageMapping("/setLike")
    @SendTo("/broker/like")
    public LikeResp like(LikeReq likeReq){
        LikeResp likeResp = new LikeResp();
        Like like = postingService.setLike(likeReq);
        BeanUtils.copyProperties(like,likeResp);

        return likeResp;
    }
}
