package com.zytc.web_3d_school.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * user_main_mission
 * @author 
 */
@Data
public class UserMainMission extends UserMainMissionKey implements Serializable {
    /**
     * 主任务描述
     */
    private String mainMissionDetail;

    /**
     * 接受主任务时间
     */
    private Date acceptTime;

    /**
     * 子任务数量
     */
    private Integer subMissionNum;

    /**
     * 完成子任务数量
     */
    private Integer completedNum;

    /**
     * 完成主任务时间
     */
    private Date completedTime;

    /**
     * 主任务是否完成：1：完成；0：未完成
     */
    private Integer completedFlag;

    private static final long serialVersionUID = 1L;
}