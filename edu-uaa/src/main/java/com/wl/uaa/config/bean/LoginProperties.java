package com.wl.uaa.config.bean;

import com.wf.captcha.*;
import com.wf.captcha.base.Captcha;

import com.wl.common.exception.BadConfigurationException;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.util.Objects;

/**
 * 配置文件读取
 *
 * @author liaojinlong
 */
@Data
public class LoginProperties {
    /**
     * 账号单用户 登录
     */
    private boolean singleLogin = false;


    /**
     * 用户登录信息缓存
     */
    private boolean cacheEnable;

    public boolean isSingleLogin() {
        return singleLogin;
    }

    public boolean isCacheEnable() {
        return cacheEnable;
    }

}
