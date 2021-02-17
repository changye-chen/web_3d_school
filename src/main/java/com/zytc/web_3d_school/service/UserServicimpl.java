package com.zytc.web_3d_school.service;

import com.zytc.web_3d_school.dao.mapper.UserMapper;
import com.zytc.web_3d_school.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicimpl implements UserService{
    @Autowired(required = false)
    UserMapper userMapper;
    @Override
    public User CheckUser(User user){
        return userMapper.CheckUser(user);
    }
}
