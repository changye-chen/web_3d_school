package com.zytc.web_3d_school.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: web_3d_school
 * @description: 适配Security的角色
 * @author: ChangYe-Chen
 * @create: 2021-02-25
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecurityRole implements Serializable {
    private int id;

    /**
     * 角色英文名称
     */
    private String nameEn;

    /**
     * 角色中文名称
     */
    private String nameCn;

    /**
     * 角色类型
     */
    private Integer groupType;

    /**
     * 角色独立
     */
    private Boolean onAlone;
}
