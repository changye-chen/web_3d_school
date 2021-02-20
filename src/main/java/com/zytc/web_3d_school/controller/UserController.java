package com.zytc.web_3d_school.controller;

import com.zytc.web_3d_school.pojo.User;
import com.zytc.web_3d_school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/login")
    public String login(
            @RequestParam("Email") String email,
            @RequestParam("Password") String password,
            Model model,
            HttpSession session
    ) {
        //判断登录业务
        User user = new User(email,password);
        User u = userService.CheckUser(user);
        if(u == null) {
            model.addAttribute("msg", "请输入正确的登录名和密码");
            return "index";
        }else{
            return "ChinaMap";
        }
    }

}

