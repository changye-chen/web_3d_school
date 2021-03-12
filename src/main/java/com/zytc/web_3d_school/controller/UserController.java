package com.zytc.web_3d_school.controller;

import com.zytc.web_3d_school.entity.User;
import com.zytc.web_3d_school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;

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

}

