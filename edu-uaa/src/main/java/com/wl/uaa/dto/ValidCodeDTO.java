package com.wl.uaa.dto;

import lombok.Data;

/**
 * 验证码生成
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@Data
public class ValidCodeDTO {
    /**
     * 动作：登录（login） 修改密码（restPassword）
     */
    private String action;
    /**
     * 通道：sms短信  email  图形
     */
    private String channel;
    /**
     * 目标：sms通过手机号码 email通过邮件
     */
    private String target;
}
