package com.zytc.web_3d_school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoomController {
    @RequestMapping("/room")
    public String room(){
        return "room";
    }

}
