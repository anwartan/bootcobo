/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cobo.bootcobo.entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 *
 * @author Kinsley
 */
@Document
public class User {
    @Id
    private String id;
    private String name;
    private String username;
    private String email;
    private String bio;
    private Date updated_at;
    private Long deposit;
    private Date created_at;
    private Long withdrawal;

    public User(String id, String name, String username, String email, String bio, Date updated_at, Long deposit, Date created_at, Long withdrawal) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.bio = bio;
        this.updated_at = updated_at;
        this.deposit = deposit;
        this.created_at = created_at;
        this.withdrawal = withdrawal;
    }
}
