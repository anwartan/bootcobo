/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cobo.bootcobo.entity.admin;

import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Kinsley
 */
@Data
public class AdminLog {
    @Id
    String id;
    String deskripsi;
    Date createDate;
    String activity;
    String ip;
    String username;
    String target;
            
}
