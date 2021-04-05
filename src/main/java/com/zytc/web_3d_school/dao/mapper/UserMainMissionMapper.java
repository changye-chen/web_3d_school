package com.zytc.web_3d_school.dao.mapper;

import com.zytc.web_3d_school.pojo.UserMainMission;
import com.zytc.web_3d_school.pojo.UserMainMissionKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMainMissionMapper {
    int deleteByPrimaryKey(UserMainMissionKey key);

    int insert(UserMainMission record);

    int insertSelective(UserMainMission record);

    UserMainMission selectByPrimaryKey(UserMainMissionKey key);

    int updateByPrimaryKeySelective(UserMainMission record);

    int updateByPrimaryKey(UserMainMission record);
}