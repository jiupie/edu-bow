package com.wl.uaa.valid;

import cn.hutool.core.util.IdUtil;
import com.wf.captcha.base.Captcha;
import com.wl.core.redis.core.RedisService;
import com.wl.uaa.config.bean.PictureCodeEnum;
import com.wl.uaa.config.bean.SecurityProperties;
import com.wl.uaa.config.bean.ValidCode;
import com.wl.uaa.dto.ValidCodeDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 图形验证码
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */

public class CaptchaValidCode extends AbstractValidCode {
    public CaptchaValidCode(SecurityProperties securityProperties, RedisService redisService) {
        super(securityProperties, redisService);
    }

    @Override
    public ValidCode creatValidCode(ValidCodeDTO validCodeDTO) {
        // 获取运算的结果
        Captcha captcha = securityProperties.getCaptcha();
        String uuid = securityProperties.getCodeKey() + IdUtil.simpleUUID();

        //当验证码类型为 arithmetic时且长度 >= 2 时，captcha.text()的结果有几率为浮点型
        String captchaValue = captcha.text();
        if (captcha.getCharType() - 1 == PictureCodeEnum.arithmetic.ordinal() && captchaValue.contains(".")) {
            captchaValue = captchaValue.split("\\.")[0];
        }
        // 验证码信息
        Map<String, Object> imgResult = new HashMap<>(2) {{
            put("img", captcha.toBase64());
            put("uuid", uuid);
        }};
        ValidCode validCode = new ValidCode();
        validCode.setKey(uuid);
        validCode.setValue(captchaValue);
        validCode.setInfo(imgResult);

        return validCode;
    }
}
