package com.zytc.web_3d_school.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @program: web_3d_school
 * @description: 适配Security的权限
 * @author: ChangYe-Chen
 * @create: 2021-02-25
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecurityPermission implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String url;
    private String title;
    private List<SecurityRole> roles;
}
