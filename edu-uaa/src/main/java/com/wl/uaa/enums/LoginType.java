package com.wl.uaa.enums;

import lombok.Getter;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@Getter
public enum LoginType {
    /*短信验证码  手机验证码*/
    SMS("sms", "短信登录"),
    /*邮件密码登录  密码*/
    EMAIL("email", "邮件登录"),
    /*手机号码密码登录  密码*/
    PASSWORD("password", "密码登录"),
    /*用户名密码登录 图形验证码*/
    USERNAME("username", "用户名登录");
    private String type;
    private String description;

    LoginType(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public static LoginType findValue(String loginType) {
        LoginType[] values = LoginType.values();
        for (LoginType value : values) {
            if (loginType.equals(value.getType())) {
                return value;
            }
        }
        return null;
    }

}
