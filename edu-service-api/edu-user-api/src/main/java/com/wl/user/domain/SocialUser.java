package com.wl.user.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 南顾北衫
 */
@TableName(value = "social_user")
@Data
public class SocialUser implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 第三方系统的唯一ID
     */
    private String uuid;

    /**
     * 第三方用户来源
     */
    private String source;

    /**
     * 用户的授权令牌
     */
    private String accessToken;

    /**
     * 第三方用户的授权令牌的有效期
     */
    private Integer expireIn;

    /**
     * 刷新令牌
     */
    private String refreshToken;

    /**
     * 第三方用户的 open id
     */
    private String openId;


}