package com.cobo.bootcobo.model.response;

import com.cobo.bootcobo.entity.Comment;
import com.cobo.bootcobo.entity.Like;

import java.util.ArrayList;
import java.util.List;

public class PostingResp extends BaseResponse {


    private String image_url;
    private String description;
    private List<Comment> comments = new ArrayList<>();
    private List<Like> likes = new ArrayList<>();

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
