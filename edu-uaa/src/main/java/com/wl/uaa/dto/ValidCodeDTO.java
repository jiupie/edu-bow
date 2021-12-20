package com.wl.uaa.dto;

import lombok.Data;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@Data
public class ValidCodeDTO {
    /**
     * 动作：登录（login） 修改密码（）
     */
    private String action;
    /**
     * 通道：sms短信
     */
    private String channel;
    /**
     * 目标：sms通过手机号码
     */
    private String target;
}
