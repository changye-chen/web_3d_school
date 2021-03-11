package com.zytc.web_3d_school.dao.mapper;

import com.zytc.web_3d_school.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    User select(@Param("User") User user);
}
