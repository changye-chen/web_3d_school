package com.zytc.web_3d_school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: web_3d_school
 * @description: As it's name shows
 * @author: ChangYe-Chen
 * @create: 2021-02-19
 **/

@Controller
public class RoomController {
    @RequestMapping("/JavaStudio")
    public String room(){
        return "JavaStudio";
    }
    @RequestMapping("/BigDataStudio")
    public String room1(){
        return "BigDataStudio";
    }

    @RequestMapping("/cssStudio")
    public String room2(){
        return "cssStudio";
    }

    @RequestMapping("/IndustryStudio")
    public String room3(){
        return "IndustryStudio";
    }

    @RequestMapping("/VisionStudio")
    public String room4(){
        return "VisionStudio";
    }
}
