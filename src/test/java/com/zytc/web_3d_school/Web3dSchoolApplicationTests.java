package com.zytc.web_3d_school;

import com.zytc.web_3d_school.dao.mapper.UserMapper;
import com.zytc.web_3d_school.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Web3dSchoolApplicationTests {
    @Autowired
    UserMapper userDetailsService;
    @Test
    void contextLoads() {
        System.out.println(userDetailsService.select(new User("1878281217@163.com","123456")).getLogin_name());

    }

}
