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
public class BuildingController {
    @RequestMapping("/building")
    public String building(){
        return "Building";
    }
}
