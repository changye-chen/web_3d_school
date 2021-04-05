package com.zytc.web_3d_school.controller;

import com.zytc.web_3d_school.pojo.SecurityUser;
import com.zytc.web_3d_school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: web_3d_school
 * @description: As it's name shows
 * @author: ChangYe-Chen
 * @create: 2021-02-19
 **/

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/detail")
    public String detail(){
        return "index";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/acceptMission")
    @ResponseBody
    public String acceptMission() {
        SecurityUser user = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user == null)
            return "请先登录";
        if(userService.acceptMission(user)!=0)
            return "ok";
        return "failed";
    }
    @RequestMapping("/completeSubMission")
    @ResponseBody
    public String completeSubMission(){
        SecurityUser user = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user == null)
            return "请先登录";
        if(userService.completeSubMission(user)!=0)
            return "ok";
        return "failed";
    }

}

