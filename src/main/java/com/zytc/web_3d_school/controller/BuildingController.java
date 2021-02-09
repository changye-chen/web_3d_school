package com.zytc.web_3d_school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BuildingController {
    @RequestMapping("/building")
    public String building(){
        return "Building";
    }
}
