package com.wl.user.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.wl.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName user
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="user")
@Data
public class User extends BaseEntity {
    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户昵称
     */
    private String name;

    /**
     * email
     */
    private String email;

    /**
     * 用户头像地址
     */
    private String portrait;

    /**
     * 注册手机
     */
    private String phone;

    /**
     * 用户密码（可以为空，支持只用验证码注册、登录）
     */
    private String password;

    /**
     * 注册ip
     */
    private String regIp;

    /**
     * 是否有效用户
     */
    private Boolean accountNonExpired;

    /**
     * 账号是否未过期
     */
    private Boolean credentialsNonExpired;

    /**
     * 是否未锁定
     */
    private Boolean accountNonLocked;

    /**
     * 用户状态：ENABLE能登录，DISABLE不能登录
     */
    private String status;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isDel;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}