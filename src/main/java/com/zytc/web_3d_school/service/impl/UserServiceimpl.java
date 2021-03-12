package com.zytc.web_3d_school.service.impl;

import com.zytc.web_3d_school.dao.mapper.UserDetailsServiceMapper;
import com.zytc.web_3d_school.dao.mapper.UserMapper;
import com.zytc.web_3d_school.entity.User;
import com.zytc.web_3d_school.pojo.SecurityUser;
import com.zytc.web_3d_school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;


@Service
public class UserServiceimpl implements UserService {
    @Autowired(required = false)
    UserDetailsServiceMapper userDetailsServiceMapper;
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
}