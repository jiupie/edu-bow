package com.wl.uaa.enums;

import lombok.Getter;

/**
 * 登录类型+验证码类型+验证码值 唯一
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@Getter
public enum ValidCodeType {
    VALID_CODE_LOGIN_TYPE("login", "登录验证码"),
    VALID_CODE_RESET_PWD_TYPE("restPassword", "修改密码验证码")
    ;


    private String type;
    private String description;

    ValidCodeType(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public static ValidCodeType findValue(String validCodeType) {
        ValidCodeType[] values = ValidCodeType.values();
        for (ValidCodeType value : values) {
            if (validCodeType.equals(value.getType())) {
                return value;
            }
        }
        return null;
    }
}
