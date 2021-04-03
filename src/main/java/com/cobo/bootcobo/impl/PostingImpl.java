package com.cobo.bootcobo.impl;

import com.cobo.bootcobo.entity.Comment;
import com.cobo.bootcobo.entity.Like;
import com.cobo.bootcobo.entity.Posting;
import com.cobo.bootcobo.model.request.CommentReq;
import com.cobo.bootcobo.model.request.LikeReq;
import com.cobo.bootcobo.model.request.PostingReq;
import com.cobo.bootcobo.repo.PostingRepo;
import com.cobo.bootcobo.service.PostingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Date;
import java.util.List;
@Service
public class PostingImpl implements PostingService {

    @Autowired
    private PostingRepo postingRepo;

    @Override
    public List<Posting> getAll() {
        return postingRepo.findAll();
    }

    @Override
    public Posting create(PostingReq postingReq) {
        Posting posting = new Posting();
        BeanUtils.copyProperties(postingReq,posting);
        posting.setCreated_at(new Date());
        posting.setUpdated_at(posting.getCreated_at());
        return postingRepo.save(posting);
    }

    public Comment addComment(CommentReq commentReq){
        Posting posting = findById(commentReq.getPostingId());
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentReq,comment);
        comment.setCreated_at(new Date());
        comment.setUpdated_at(comment.getCreated_at());
        posting.addComment(comment);
        postingRepo.save(posting);
        return  comment;
    }

    @Override
    public Like setLike(LikeReq likeReq) {
        Posting posting = findById(likeReq.getPostingId());
        Like like = new Like();
        BeanUtils.copyProperties(likeReq,like);
        like.setCreated_at(new Date());
        like.setUpdated_at(like.getCreated_at());
        posting.setLike(like);
        postingRepo.save(posting);
        return  like;
    }

    private Posting findById(String id){
        return  postingRepo.findById(id).orElseThrow(()->new NotFoundException("Posting tidak ditemukan"));

    }

}
