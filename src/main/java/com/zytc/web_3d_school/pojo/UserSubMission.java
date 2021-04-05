package com.zytc.web_3d_school.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * user_sub_mission
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSubMission extends UserSubMissionKey implements Serializable {
    /**
     * 主任务id
     */
    private Integer mainMissionId;

    /**
     * 子任务描述
     */
    private String subMissionDetail;

    /**
     * 子任务视频路径
     */
    private String videoUrl;

    /**
     * 接受子任务时间
     */
    private Date acceptTime;

    /**
     * 完成子任务时间
     */
    private Date completedTime;

    /**
     * 子任务是否完成：1：完成；0：未完成
     */
    private Integer completedFlag;

    private static final long serialVersionUID = 1L;
}