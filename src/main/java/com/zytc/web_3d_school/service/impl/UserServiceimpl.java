package com.zytc.web_3d_school.service.impl;

import com.zytc.web_3d_school.dao.mapper.UserMapper;
import com.zytc.web_3d_school.entity.User;
import com.zytc.web_3d_school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {
    @Autowired(required = false)
    UserMapper userMapper;
    /** 
    * @Description:  
    * @Param: [user] 
    * @return: com.zytc.web_3d_school.entity.User 
    * @Author: ChangYe-Chen
    * @Date: 2021/2/25 
    */
    @Override
    public User CheckUser(User user){
        return userMapper.select(user);
    }
}
