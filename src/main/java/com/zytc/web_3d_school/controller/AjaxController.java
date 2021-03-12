package com.zytc.web_3d_school.controller;

import com.zytc.web_3d_school.pojo.SecurityUser;
import com.zytc.web_3d_school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.PublicKey;

/**
 * @program: web_3d_school
 * @description: ajax测试
 * @author: ChangYe-Chen
 * @create: 2021-03-04
 **/
@Controller
@RequestMapping("/ajax")
public class AjaxController {
    @Autowired
    private UserService userService;
    @Qualifier("userDetailsServiceimpl")
    @Autowired
    private UserDetailsService userDetailsService;
    @RequestMapping("/getMission")
    @ResponseBody
    public String getMission(){
        return userDetailsService.loadUserByUsername("18782812147@163.com").getUsername();
    }
    @RequestMapping("/register")
    @ResponseBody
    public String registerConfirm(SecurityUser user){
        System.out.println(user.toString());
        userService.userRegister(user);
        return "OK";
    }
}
