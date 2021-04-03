/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cobo.bootcobo.impl;

import com.cobo.bootcobo.entity.RoleMenu;
import com.cobo.bootcobo.repo.MenuRepo;
import com.cobo.bootcobo.service.RoleMenuService;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kinsley
 */
@Service
public class RoleMenuImpl implements RoleMenuService {

    @Autowired
    MenuRepo menuRepo;

    @Override
    public JSONArray getAll() {
        JSONArray jsonArray = new JSONArray();
        JSONArray test = new JSONArray();
        List<RoleMenu> listParent = getHighestParent();
        for (RoleMenu rm : listParent) {
            JSONObject obj = new JSONObject();
            obj.put("id", rm.getId());
            obj.put("menuId", rm.getMenuId());
            obj.put("parentId", rm.getParentId());
            obj.put("isParent", rm.getIsParent());
            obj.put("isSystem", rm.getIsSystem());
            obj.put("label", rm.getLabel());
            test = recursiveMenu(rm.getMenuId());
            obj.put("items", test);
            jsonArray.add(obj);
        }
        return jsonArray;
    }

    @Override
    public List<RoleMenu> getMenuNotParentAndIsSystem() {
        return menuRepo.findByIsParentAndIsSystem(0, 1);
    }

    @Override
    public RoleMenu add(RoleMenu roleMenu) {
        return menuRepo.save(roleMenu);
    }

    @Override
    public List<RoleMenu> getAllByParentId(Integer parentId) {
        return menuRepo.findByParentId(parentId);
    }

    private JSONArray recursiveMenu(Integer parentId) {
        JSONArray arr = new JSONArray();
        List<RoleMenu> listRoleMenu = getAllByParentId(parentId);
        for (RoleMenu rm : listRoleMenu) {
            JSONArray items = new JSONArray();
            JSONObject obj = new JSONObject();
            obj.put("id", rm.getId());
            obj.put("menuId", rm.getMenuId());
            obj.put("parentId", rm.getParentId());
            obj.put("isParent", rm.getIsParent());
            obj.put("isSystem", rm.getIsSystem());
            obj.put("label", rm.getLabel());
            if (rm.getIsParent() == 1) {
                items = recursiveMenu(rm.getMenuId());
            }
            obj.put("items", items);
            arr.add(obj);
        }
        return arr;
    }

    @Override
    public RoleMenu getMenuById() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private List<RoleMenu> getHighestParent() {
        return menuRepo.findByParentIdAndIsParent(0, 1);
    }

}
