package com.zytc.web_3d_school.controller;

import com.zytc.web_3d_school.pojo.SecurityUser;
import com.zytc.web_3d_school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @program: web_3d_school
 * @description: ajax
 * @author: ChangYe-Chen
 * @create: 2021-03-04
 **/
@Controller
@RequestMapping("/ajax")
public class AjaxController {
    @Autowired
    private UserService userService;
    @Qualifier("userDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;
    @RequestMapping("/getMission")
    @ResponseBody
    public String getMission(){
        SecurityUser user = (SecurityUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.getMission(user).getMainMissionDetail();
    }

    @RequestMapping("/register")
    @ResponseBody
    public String registerConfirm(SecurityUser user){
        System.out.println(user.toString());
        if(userService.userRegister(user)==1){
            return "注册成功";
        }
        return "该用户名已存在";
    }

    @RequestMapping("/load")
    @ResponseBody
    public String loadFile(String addr){
        try {
            File file = new File(addr);
            if(file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                StringBuilder context = new StringBuilder();
                String lineTxt;
                while ((lineTxt = br.readLine()) != null) {
                    System.out.println(lineTxt);
                    context.append(lineTxt);
                }
                br.close();
                return context.toString();
            } else {
                System.out.println("文件不存在!");
                return "文件不存在";
            }
        } catch (Exception e) {
            System.out.println("文件读取错误!");
            return "文件读取错误";
        }
    }

}
