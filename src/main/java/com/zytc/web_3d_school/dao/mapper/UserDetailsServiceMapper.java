package com.zytc.web_3d_school.dao.mapper;

import com.sun.org.apache.xpath.internal.operations.Bool;
//import com.zytc.web_3d_school.pojo.SecurityPermission;
import com.zytc.web_3d_school.pojo.SecurityUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * @program: web_3d_school
 * @description: As it's name shows
 * @author: ChangYe-Chen
 * @create: 2021-02-21
 **/

@Mapper
@Repository
public interface UserDetailsServiceMapper {
    /**
    * @Description: 查询数据库用户
    * @Param:   [Username]
    * @return:  com.zytc.web_3d_school.pojo.SecurityUser
    * @Author: ChangYe-Chen
    * @Date: 2021/2/25
    */
    SecurityUser loadUserByUsername(@Param("username")String username);
    /** 
    * @Description:  插入用户数据
    * @Param: [user] 
    * @return: int 
    * @Author: ChangYe-Chen
    * @Date: 2021/3/10 
    */
    int insertUser(@Param("user")SecurityUser user);
}
