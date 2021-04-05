package com.zytc.web_3d_school.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * user_main_mission
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMainMissionKey implements Serializable {
    /**
     * 主任务id
     */
    private Integer mainMissionId;

    /**
     * 用户id
     */
    private Integer userId;

    private static final long serialVersionUID = 1L;
}