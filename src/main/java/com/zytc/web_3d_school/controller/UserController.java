package com.zytc.web_3d_school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller
public class UserController {
    @RequestMapping("/login")
    public String login(
            @RequestParam("Email") String email,
            @RequestParam("Password") String password,
            Model model,
            HttpSession session
    ) {
        //判断登录业务
        if(!email.isEmpty() && password.equals("123456")) {
            session.setAttribute("UserLogin",email);
            return "china";
        }else {
            model.addAttribute("msg","请输入正确的邮箱和密码！");
            return "index";
        }
    }

}
