package com.wl.uaa.config.bean;

import lombok.Data;

/**
 * 图形验证码配置信息
 *
 * @author liaojinlong
 */
@Data
public class PictureCode {

    /**
     * 验证码配置
     */
    private PictureCodeEnum codeType;

    /**
     * 验证码内容长度
     */
    private int length = 2;
    /**
     * 验证码宽度
     */
    private int width = 111;
    /**
     * 验证码高度
     */
    private int height = 36;
    /**
     * 验证码字体
     */
    private String fontName;
    /**
     * 字体大小
     */
    private int fontSize = 25;

    public PictureCodeEnum getCodeType() {
        return codeType;
    }
}
