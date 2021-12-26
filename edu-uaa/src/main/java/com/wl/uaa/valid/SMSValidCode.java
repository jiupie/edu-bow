package com.wl.uaa.valid;

import com.wl.core.redis.core.RedisService;
import com.wl.uaa.config.bean.LoginProperties;
import com.wl.uaa.config.bean.SecurityProperties;
import com.wl.uaa.config.bean.ValidCode;
import com.wl.uaa.dto.ValidCodeDTO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.apache.bcel.classfile.Code;

import javax.validation.Valid;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 手机验证码
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@Slf4j
public class SMSValidCode extends AbstractValidCode {
    public SMSValidCode(SecurityProperties securityProperties, RedisService redisService) {
        super(securityProperties, redisService);
    }

    @Override
    public ValidCode creatValidCode(ValidCodeDTO validCodeDTO) {
        String code = generateSimpleCode();
        validCodeDTO.setCode(code);
        Map<String, String> map = buildKey(validCodeDTO);

        ValidCode validCode = new ValidCode();
        validCode.setKey(map.get("key"));
        log.info("生成短信验证码：{}", map.get("code"));
        return validCode;
    }
}
