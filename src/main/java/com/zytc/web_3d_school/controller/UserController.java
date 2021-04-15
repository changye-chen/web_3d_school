package com.zytc.web_3d_school.controller;

//import com.alibaba.fastjson.JSONObject;
import com.zytc.web_3d_school.pojo.SecurityUser;
import com.zytc.web_3d_school.pojo.UserMainMission;
import com.zytc.web_3d_school.pojo.UserSubMission;
import com.zytc.web_3d_school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping("/getSubMission")
    @ResponseBody
    public String getSubMission(){
        SecurityUser user = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserSubMission userSubMission = userService.getSubMission(user);
        return userSubMission.getSubMissionDetail();
    }
    
    @RequestMapping("/getMainMission")
    @ResponseBody
    public String getMainMission(){
        SecurityUser user = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserMainMission userMainMission = userService.getMainMission(user);
        return userMainMission.getMainMissionDetail();
    }

    @RequestMapping("/getCompletedNum")
    @ResponseBody
    public int getCompletedNum(){
        SecurityUser user = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SecurityUser user1 = userService.getUser(user);
        return user1.getMain_mission_id()-1;
    }
    
    
    @RequestMapping("/getVideoUrl")
    @ResponseBody
    public String getVideoUrl(){
        SecurityUser user = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserSubMission userSubMission = userService.getSubMission(user);
        return userSubMission.getVideoUrl();
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

     @RequestMapping("/upload")
     @ResponseBody
     public String upload(@RequestParam("myfile")MultipartFile multipartFile){
         if(multipartFile.isEmpty()){
             return "文件为空";
         }
         InputStream inputStream = null;
         OutputStream outputStream = null;
         try {
             //指定上传的位置为 d:/upload/
             String path = "/usr/upload/";
             //获取文件的输入流
             inputStream = multipartFile.getInputStream();
             //获取上传时的文件名
             String fileName = multipartFile.getOriginalFilename();
             //注意是路径+文件名
             File targetFile = new File(path + fileName);
             //如果之前的 String path = "d:/upload/" 没有在最后加 / ，那就要在 path 后面 + "/"

             //判断文件父目录是否存在
             if(!targetFile.getParentFile().exists()){
                 //不存在就创建一个
                 targetFile.getParentFile().mkdir();
             }

             //获取文件的输出流
             outputStream = new FileOutputStream(targetFile);
             //最后使用资源访问器FileCopyUtils的copy方法拷贝文件
             FileCopyUtils.copy(inputStream, outputStream);
         /*参数是通过源码
             public static int copy(InputStream in, OutputStream out) throws IOException {
                 ......
             }
        而得知的*/

             //告诉页面上传成功了
             return "上传成功";
         } catch (IOException e) {
             e.printStackTrace();
             //出现异常，则告诉页面失败
             return "上传失败";
         } finally {
             //无论成功与否，都有关闭输入输出流
             if (inputStream != null) {
                 try {
                     inputStream.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
             if (outputStream != null) {
                 try {
                     outputStream.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         }
     }
}

