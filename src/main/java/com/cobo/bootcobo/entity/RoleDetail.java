/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cobo.bootcobo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Kinsley
 */
@Document
public class RoleDetail {
    @Id
    String id;
    String roleId;
    String menuId;
    
}
