package com.zytc.web_3d_school.service.impl;

import com.zytc.web_3d_school.dao.mapper.MainMissionMapper;
import com.zytc.web_3d_school.dao.mapper.UserDetailsServiceMapper;
import com.zytc.web_3d_school.pojo.MainMission;
import com.zytc.web_3d_school.pojo.SecurityUser;
import com.zytc.web_3d_school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;


@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserDetailsServiceMapper userDetailsServiceMapper;
    @Autowired
    private MainMissionMapper mainMissionMapper;
    /**
    * @Description:
    * @Param: [user]
    * @return: com.sun.org.apache.xpath.internal.operations.Bool
    * @Author: ChangYe-Chen
    * @Date: 2021/3/07
    */
    @Override
    public int userRegister(SecurityUser user){
        user.setCreate_time(new Timestamp(new Date().getTime()));
        //已审核，额，就是这样
        user.setIs_examine(1);
        user.setStatus((byte) 0);
        return userDetailsServiceMapper.insertUser(user);
    }

    @Override
    public MainMission getMission(SecurityUser user) {
        return mainMissionMapper.selectByPrimaryKey(user.getMain_mission_id());
    }


}