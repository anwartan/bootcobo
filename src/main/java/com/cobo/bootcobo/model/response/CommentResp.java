package com.cobo.bootcobo.model.response;

import java.util.Date;

public class CommentResp extends BaseResponse{


    private String message;

    private String userId;

    private String postingId;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPostingId() {
        return postingId;
    }

    public void setPostingId(String postingId) {
        this.postingId = postingId;
    }


}
