package com.cobo.bootcobo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Document
public class Posting {
    @Id
    private String id;
    private String image_url;
    private String description;
    private Date created_at;
    private Date updated_at;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }


    public void addComment(Comment comment){
        comments.add(comment);
    }
    public void addLike(Like like){
        likes.add(like);
    }
    public boolean setLike(Like a){
        boolean status = false;
        for (Like like:likes) {
            if(like.getUserId().equals(a.getUserId())){
                like.setStatus(a.getStatus());
                like.setUpdated_at(a.getCreated_at());
                status=true;
                break;
            }
        }
        if(!status){
            likes.add(a);
        }
        return true;
    }


}
