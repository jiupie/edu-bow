package com.wl.common.enums;

import com.wl.common.base.IResultCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@Getter
@AllArgsConstructor
public enum ResultCode implements IResultCode {
    /**
     * 请求未授权
     */
    UN_AUTHORIZED(HttpServletResponse.SC_UNAUTHORIZED, "请求未授权"),
    SUCCESS(HttpServletResponse.SC_OK, "success"),
    ERROR(1003, "服务器错误"),
    VALID_CHANNEL_NOT_EXIST(HttpServletResponse.SC_BAD_REQUEST, "没有该验证码通道"),
    VALID_CODE_ERROR(HttpServletResponse.SC_BAD_REQUEST, "验证码错误");

    /**
     * code编码
     */
    final int code;
    /**
     * 中文信息描述
     */
    final String message;
}
