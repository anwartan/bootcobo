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
public class RoleMenu {
    @Id
    String id;
    Integer menuId;
    Integer parentId;
    Integer isParent;
    String icon;
    String to;
    String label;
    //if system hide from menu tree
    Integer isSystem;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getIsParent() {
        return isParent;
    }

    public void setIsParent(Integer isParent) {
        this.isParent = isParent;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(Integer isSystem) {
        this.isSystem = isSystem;
    }

    public RoleMenu(){
    }
    public RoleMenu(String id,Integer menuId,Integer parentId,Integer isParent,String label,String icon,String to,Integer isSystem){
        this.id=id;
        this.menuId=menuId;
        this.parentId=parentId;
        this.isParent=isParent;
        this.label=label;
        this.isSystem=isSystem;
        this.icon=icon;
        this.to=to;
    }
}

