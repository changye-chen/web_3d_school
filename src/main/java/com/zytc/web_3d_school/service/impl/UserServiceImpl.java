package com.zytc.web_3d_school.service.impl;

import com.zytc.web_3d_school.dao.mapper.*;
import com.zytc.web_3d_school.pojo.*;
import com.zytc.web_3d_school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserDetailsServiceMapper userDetailsServiceMapper;
    @Autowired
    private MainMissionMapper mainMissionMapper;
    @Autowired
    private SubMissionMapper subMissionMapper;
    @Autowired
    private UserMainMissionMapper userMainMissionMapper;
    @Autowired
    private UserSubMissionMapper userSubMissionMapper;
    /**
    * @Description:
    * @Param: [user]
    * @return: int
    * @Author: ChangYe-Chen
    * @Date: 2021/3/30
    */
    @Override
    public int userRegister(SecurityUser user){
        user.setCreate_time(new Timestamp(new Date().getTime()));
        //已审核，额，就是这样
        user.setIs_examine(1);
        user.setStatus((byte) 0);
        if(userDetailsServiceMapper.loadUserByUsername(user.getUsername())==null) {
            return userDetailsServiceMapper.insertUser(user);
        }
        return 0;
    }
    /**
    * @Description:
    * @Param: [user]
    * @return: com.zytc.web_3d_school.pojo.MainMission
    * @Author: ChangYe-Chen
    * @Date: 2021/3/30
    */
    @Override
    public MainMission getMission(SecurityUser user) {
        SecurityUser userWithPwd = userDetailsServiceMapper.loadUserByUsername(user.getUsername());
        return mainMissionMapper.selectByPrimaryKey(userWithPwd.getMain_mission_id());
    }
    /**
    * @Description:
    * @Param:
    * @return:
    * @Author: ChangYe-Chen
    * @Date: 2021/3/30
    */
    @Override
    public int acceptMission(SecurityUser user) {
        //获取主任务表
        SecurityUser userWithPwd = userDetailsServiceMapper.loadUserByUsername(user.getUsername());
        MainMission mainmission = mainMissionMapper.selectByPrimaryKey(userWithPwd.getMain_mission_id());
        //主任务添加到用户主任务表
        System.out.println(mainmission.toString());
        UserMainMission userMainMission = new UserMainMission();
        userMainMission.setAcceptTime(new Date());
        userMainMission.setMainMissionDetail(mainmission.getMainMissionDetail());
        userMainMission.setMainMissionId(mainmission.getMainMissionId());
        userMainMission.setSubMissionNum(mainmission.getSubMissionNum());
        userMainMission.setUserId(userWithPwd.getUser_id());
        userMainMission.setCompletedNum(0);
        //获取子任务表
        List<SubMission> subMissions= subMissionMapper.selectByMainMissionId(mainmission.getMainMissionId());
        //更新用户表
        userWithPwd.setSub_mission_id(subMissions.get(0).getSubMissionId());
        userDetailsServiceMapper.updateUser(userWithPwd);
        //子任务添加到用户子任务表
        //应该由触发器完成，在此反省
        for(SubMission subMission : subMissions){
            System.out.println(subMission.toString());
            UserSubMission userSubMission = new UserSubMission();
            userSubMission.setUserId(user.getUser_id());
            userSubMission.setSubMissionDetail(subMission.getSubMissionDetail());
            userSubMission.setMainMissionId(mainmission.getMainMissionId());
            userSubMission.setAcceptTime(new Date());
            userSubMission.setCompletedFlag(0);
            userSubMission.setVideoUrl(subMission.getVideoUrl());
            userSubMission.setSubMissionId(subMission.getSubMissionId());
            if(userSubMissionMapper.selectByPrimaryKey(new UserSubMissionKey(userSubMission.getSubMissionId(),userMainMission.getMainMissionId(),userMainMission.getUserId()))==null){
                userSubMissionMapper.insert(userSubMission);
            }
        }
        if (userMainMissionMapper.selectByPrimaryKey(new UserMainMissionKey(userMainMission.getMainMissionId(),userMainMission.getUserId()))==null){
            return userMainMissionMapper.insert(userMainMission);

        }

        return 0;
    }
    /**
    * @Description:
    * @Param: [user]
    * @return: int
    * @Author: ChangYe-Chen
    * @Date: 2021/3/31
    */
    @Override
    public int completeSubMission(SecurityUser user) {
        SecurityUser userWithPwd = userDetailsServiceMapper.loadUserByUsername(user.getUsername());
        System.out.println(userWithPwd.toString());
        UserSubMission userSubMission = userSubMissionMapper.selectByPrimaryKey(new UserSubMissionKey(userWithPwd.getSub_mission_id(),userWithPwd.getMain_mission_id(),userWithPwd.getUser_id()));
        userSubMission.setCompletedFlag(1);
        userSubMission.setCompletedTime(new Date());

        if(userSubMissionMapper.selectByPrimaryKey(new UserSubMissionKey(userWithPwd.getSub_mission_id()+1,userWithPwd.getMain_mission_id(),userWithPwd.getUser_id()))!=null)
            userWithPwd.setSub_mission_id(userWithPwd.getSub_mission_id()+1);

        UserMainMission userMainMission = userMainMissionMapper.selectByPrimaryKey(new UserMainMissionKey(userWithPwd.getMain_mission_id(),userWithPwd.getUser_id()));
        userMainMission.setCompletedNum(userMainMission.getCompletedNum()+1);
        if(userMainMission.getCompletedNum()>=userMainMission.getSubMissionNum()) {
            userMainMission.setCompletedFlag(1);
            userMainMission.setCompletedTime(new Date());
            userWithPwd.setMain_mission_id(userWithPwd.getMain_mission_id() + 1);
            userWithPwd.setSub_mission_id(1);
        }
        //更新用户表
        userDetailsServiceMapper.updateUser(userWithPwd);
        //更新用户主任务表
        userMainMissionMapper.updateByPrimaryKey(userMainMission);
        //更新用户子任务表
        System.out.println(userSubMission.toString());
        return userSubMissionMapper.updateByPrimaryKey(userSubMission);
    }

    @Override
    public UserSubMission getSubMission(SecurityUser user) {
        SecurityUser userWithPwd = userDetailsServiceMapper.loadUserByUsername(user.getUsername());
        return userSubMissionMapper.selectByPrimaryKey(new UserSubMissionKey(userWithPwd.getSub_mission_id(),userWithPwd.getMain_mission_id(),userWithPwd.getUser_id()));
    }

    @Override
    public UserMainMission getMainMission(SecurityUser user) {
        SecurityUser userWithPwd = userDetailsServiceMapper.loadUserByUsername(user.getUsername());
        return userMainMissionMapper.selectByPrimaryKey(new UserMainMissionKey(userWithPwd.getMain_mission_id(),userWithPwd.getUser_id()));
    }

    @Override
    public SecurityUser getUser(SecurityUser user) {
        return userDetailsServiceMapper.loadUserByUsername(user.getUsername());
    }
}