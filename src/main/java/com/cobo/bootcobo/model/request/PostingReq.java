package com.cobo.bootcobo.model.request;

import java.util.Date;

public class PostingReq {
    private String image_url;
    private String description;

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
