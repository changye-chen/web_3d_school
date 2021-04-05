package com.zytc.web_3d_school.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * sub_mission
 * @author 
 */
@Data
public class SubMission implements Serializable {
    /**
     * 子任务id
     */
    private Integer subMissionId;

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

    private static final long serialVersionUID = 1L;
}