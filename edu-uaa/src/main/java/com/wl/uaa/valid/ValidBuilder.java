package com.wl.uaa.valid;

import com.wl.core.redis.core.RedisService;
import com.wl.uaa.config.bean.PictureCode;
import com.wl.uaa.config.bean.SecurityProperties;
import com.wl.uaa.enums.LoginType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@Component
@RequiredArgsConstructor
public class ValidBuilder {
    private final SecurityProperties securityProperties;
    private final RedisService redisService;

    public AbstractValidCode createLoginValid(LoginType loginType){
        AbstractValidCode validCode=null;
        switch (loginType){
            case PASSWORD:
                break;
            case EMAIL:
                break;
            case SMS:
                validCode=new SMSValidCode(securityProperties,redisService);
                break;
            case USERNAME:
                validCode=new CaptchaValidCode(securityProperties,redisService);
                break;
        }
        return validCode;
    }
}
