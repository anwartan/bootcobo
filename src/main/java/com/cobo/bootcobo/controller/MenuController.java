/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cobo.bootcobo.controller;

import com.cobo.bootcobo.entity.RoleMenu;
import com.cobo.bootcobo.service.RoleMenuService;
import java.util.List;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kinsley
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private RoleMenuService roleMenuService;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public JSONArray findAll() {
        return roleMenuService.getAll();
    }


    @RequestMapping(value = "tree", method = RequestMethod.GET)
    public JSONArray findMenu() {
        return roleMenuService.getAll();
    }
    
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public RoleMenu addMenu(@RequestBody RoleMenu roleMenu) {
        return roleMenuService.add(roleMenu);
    }
    

}
