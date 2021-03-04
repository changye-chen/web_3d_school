package com.zytc.web_3d_school.service.impl;

import com.zytc.web_3d_school.dao.mapper.UserDetailsServiceMapper;
import com.zytc.web_3d_school.pojo.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @program: web_3d_school
 * @description: UserDetailsService接口实现类
 * @author: ChangYe-Chen
 * @create: 2021-02-21 20:09
 **/
@Service
public class UserDetailsServiceimpl implements UserDetailsService {
    @Autowired
    UserDetailsServiceMapper userDetailsServiceMapper;
    /**
     * @Description: 查询数据库，获取登录用户的信息
     * @Param: [login_name]
     * @return: org.springframework.security.core.userdetails.UserDetails
     * @Author: ChangYe-Chen
     * @Date: 2021/2/25
     */
    @Override
    public UserDetails loadUserByUsername(String login_name) throws UsernameNotFoundException {
        SecurityUser securityUser = userDetailsServiceMapper.loadUserByUsername(login_name);
        if(securityUser == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        securityUser.setLogin_pwd(new BCryptPasswordEncoder().encode(securityUser.getPassword()));
        System.out.println(securityUser.toString());
        return securityUser;
    }
}
