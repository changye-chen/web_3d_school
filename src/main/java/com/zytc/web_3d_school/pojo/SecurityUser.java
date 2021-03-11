package com.zytc.web_3d_school.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;

/**
 * @program: web_3d_school
 * @description: 实现UserDetails接口
 * @author: ChangYe-Chen
 * @create: 2021-02-24
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecurityUser implements UserDetails {
    //主键，用户id
    private int user_id;
    //登录名
    private String login_name;
    //登录密码
    private String login_pwd;
    //用户真实姓名
    private String user_name;
    //状态：0：正常 1：冻结 2：删除
    private byte status;
    //最后登录时间
    private Timestamp last_login_time;
    //最后登录ip
    private String last_login_ip;
    //创建时间
    private Timestamp create_time;
    //邮件地址
    private String email;
    //手机号码
    private String tel;
    //所属角色id
    private int role_id;
    //绑定角色（暂用于绑定老师，绑定分校）
    private int bindingRole;
    //随机字符串
    private String uuid;
    //审核状态 1：已审核 0：未审核
    private int is_examine;

    @Override
    public String getPassword() {
        return login_pwd;
    }

    @Override
    public String getUsername() {
        return login_name;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("user");
    }
}
