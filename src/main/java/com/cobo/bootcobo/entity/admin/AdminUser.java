/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cobo.bootcobo.entity.admin;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Kinsley
 */
@Data
public class AdminUser {
    @Id
    String id;
    String roleId;
    String name;
    String userName;
    String password;
    Integer isActive;
}
