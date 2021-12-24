package com.wl.uaa.enums;

import lombok.Getter;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@Getter
public enum ValidCodeChannelType {

    SMS("sms", "短信"), EMAIL("email", "邮件"), PICTURE("picture", "图形");

    ValidCodeChannelType(String type, String description) {
        this.type = type;
        this.description = description;
    }

    private String type;
    private String description;

    public static ValidCodeChannelType findValue(String validCodeChannelType) {
        ValidCodeChannelType[] values = ValidCodeChannelType.values();
        for (ValidCodeChannelType value : values) {
            if (validCodeChannelType.equals(value.getType())) {
                return value;
            }
        }
        return null;
    }
}
