package com.zytc.web_3d_school.dao.mapper;

import com.zytc.web_3d_school.pojo.UserSubMission;
import com.zytc.web_3d_school.pojo.UserSubMissionKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserSubMissionMapper {
    int deleteByPrimaryKey(UserSubMissionKey key);

    int insert(UserSubMission record);

    int insertSelective(UserSubMission record);

    UserSubMission selectByPrimaryKey(UserSubMissionKey key);

    int updateByPrimaryKeySelective(UserSubMission record);

    int updateByPrimaryKey(UserSubMission record);
}