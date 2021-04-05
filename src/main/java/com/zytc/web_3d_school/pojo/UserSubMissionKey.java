package com.zytc.web_3d_school.pojo;

import java.io.Serializable;

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
public class UserSubMissionKey implements Serializable {
    /**
     * 子任务id
     */
    private Integer subMissionId;

    /**
     * 用户id
     */
    private Integer userId;

    private static final long serialVersionUID = 1L;
}