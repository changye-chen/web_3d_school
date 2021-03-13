package com.zytc.web_3d_school.dao.mapper;

import com.zytc.web_3d_school.pojo.MainMission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MainMissionMapper {
    int deleteByPrimaryKey(Integer mainMissionId);

    int insert(MainMission record);

    int insertSelective(MainMission record);

    MainMission selectByPrimaryKey(Integer mainMissionId);

    int updateByPrimaryKeySelective(MainMission record);

    int updateByPrimaryKey(MainMission record);
}