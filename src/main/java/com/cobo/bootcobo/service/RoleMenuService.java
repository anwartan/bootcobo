/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cobo.bootcobo.service;

import com.cobo.bootcobo.entity.RoleMenu;
import java.util.List;
import org.json.simple.JSONArray;

/**
 *
 * @author Kinsley
 */
public interface RoleMenuService {
    JSONArray getAll();
    public RoleMenu add(RoleMenu roleMenu);
    List<RoleMenu> getAllByParentId(Integer parentId);
    List<RoleMenu> getMenuNotParentAndIsSystem();
    RoleMenu getMenuById();
}
