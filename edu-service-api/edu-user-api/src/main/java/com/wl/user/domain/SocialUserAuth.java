package com.wl.user.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName social_user_auth
 */
@TableName(value ="social_user_auth")
@Data
public class SocialUserAuth implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户Id
     */
    private Integer userId;

    /**
     * 社交用户Id
     */
    private Integer socialUserId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}