package com.wl.uaa.enums;

/**
 * 登录类型+验证码类型+验证码值 唯一
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public enum ValidCodeType {
    VALID_CODE_LOGIN_TYPE("login", "登录验证码"),
    VALID_CODE_RESET_PWD_TYPE("restPassword", "登录验证码")
    ;


    private String type;
    private String description;

    ValidCodeType(String type, String description) {
        this.type = type;
        this.description = description;
    }
}
