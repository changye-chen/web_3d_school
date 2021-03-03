package com.zytc.web_3d_school;

import com.zytc.web_3d_school.dao.mapper.UserDetailsServiceMapper;
import com.zytc.web_3d_school.dao.mapper.UserMapper;
import com.zytc.web_3d_school.entity.User;
import com.zytc.web_3d_school.pojo.SecurityUser;
import com.zytc.web_3d_school.service.impl.UserDetailsServiceimpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.sql.DataSource;

@SpringBootTest
class Web3dSchoolApplicationTests {
    @Autowired
    UserMapper userDetailsService;
    @Test
    void contextLoads() {
        System.out.println(userDetailsService.select(new User("1878281217@163.com","123456")).getLogin_name());

    }

}
