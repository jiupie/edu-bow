package com.wl.uaa.valid;

import cn.hutool.core.util.IdUtil;
import com.wf.captcha.base.Captcha;
import com.wl.core.redis.core.RedisService;
import com.wl.uaa.config.bean.LoginCodeEnum;
import com.wl.uaa.config.bean.LoginProperties;
import com.wl.uaa.config.bean.SecurityProperties;
import com.wl.uaa.dto.ValidCodeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@Component
@RequiredArgsConstructor
public class CaptchaValidCode extends AbstractValidCode{
    private final LoginProperties loginProperties;
    private final SecurityProperties properties;
    private final RedisService redisService;

    @Override
    public Map creatValidCode(ValidCodeDTO validCodeDTO) {
        // 获取运算的结果
        Captcha captcha = loginProperties.getCaptcha();
        String uuid = properties.getCodeKey() + IdUtil.simpleUUID();

        //当验证码类型为 arithmetic时且长度 >= 2 时，captcha.text()的结果有几率为浮点型
        String captchaValue = captcha.text();
        if (captcha.getCharType() - 1 == LoginCodeEnum.arithmetic.ordinal() && captchaValue.contains(".")) {
            captchaValue = captchaValue.split("\\.")[0];
        }
        // 保存
        redisService.set(uuid, captchaValue, loginProperties.getLoginCode().getExpiration(), TimeUnit.MINUTES);
        // 验证码信息
        Map<String, Object> imgResult = new HashMap<String, Object>(2) {{
            put("img", captcha.toBase64());
            put("uuid", uuid);
        }};
        return imgResult;
    }
}
