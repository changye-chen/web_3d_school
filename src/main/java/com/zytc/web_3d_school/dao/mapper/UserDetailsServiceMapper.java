package com.zytc.web_3d_school.dao.mapper;

import com.zytc.web_3d_school.pojo.SecurityPermission;
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
    * @Description:
    * @Param: []
    * @return: java.util.List<com.zytc.web_3d_school.pojo.SecurityPermission>
    * @Author: ChangYe-Chen
    * @Date: 2021/2/25
    */
}
