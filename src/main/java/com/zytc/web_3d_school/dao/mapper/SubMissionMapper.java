package com.zytc.web_3d_school.dao.mapper;

import com.zytc.web_3d_school.pojo.SubMission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SubMissionMapper {
    int deleteByPrimaryKey(Integer subMissionId);

    int insert(SubMission record);

    int insertSelective(SubMission record);

    SubMission selectByPrimaryKey(Integer subMissionId);

    List<SubMission> selectByMainMissionId(Integer mainMissionId);

    int updateByPrimaryKeySelective(SubMission record);

    int updateByPrimaryKey(SubMission record);
}