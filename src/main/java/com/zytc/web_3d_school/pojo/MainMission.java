package com.zytc.web_3d_school.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * main_mission
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainMission implements Serializable {
    /**
     * 主任务id
     */
    private Integer mainMissionId;

    /**
     * 主任务描述
     */
    private String mainMissionDetail;

    /**
     * 子任务数量
     */
    private Integer subMissionNum;

    /**
     * 主任务是否完成：1：完成；0：未完成
     */
    private Integer completedFlag;

    private static final long serialVersionUID = 1L;
}