package com.wl.uaa.dto;

import lombok.Data;

/**
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@Data
public class LoginDTO {
    /**
     * 手机号码 邮箱
     */
    private String login;

    /**
     * 登录类型：sms password email
     */
    private String loginType;
    /**
     * 密码
     */
    private String password;
    /**
     * 验证码
     */
    private String code;
}
