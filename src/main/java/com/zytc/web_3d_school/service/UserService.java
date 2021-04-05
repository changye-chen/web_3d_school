package com.zytc.web_3d_school.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zytc.web_3d_school.pojo.MainMission;
import com.zytc.web_3d_school.pojo.SecurityUser;


public interface UserService {
   /** 
   * @Description:  完成用户的注册，返回值大于0则成功
   * @Param: [user] 
   * @return: int 
   * @Author: ChangYe-Chen
   * @Date: 2021/3/10 
   */
   int userRegister(SecurityUser user);
   MainMission getMission(SecurityUser user);
   int acceptMission(SecurityUser user);
   int completeSubMission(SecurityUser user);
}
