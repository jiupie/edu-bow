package com.wl.uaa.valid;

import cn.hutool.crypto.SecureUtil;
import com.wl.core.redis.core.RedisService;
import com.wl.uaa.config.bean.SecurityProperties;
import com.wl.uaa.config.bean.ValidCode;
import com.wl.uaa.dto.ValidCodeDTO;
import com.wl.uaa.enums.ValidCodeChannelType;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public abstract class AbstractValidCode {

    protected final SecurityProperties securityProperties;
    protected final RedisService redisService;

    public AbstractValidCode(SecurityProperties securityProperties, RedisService redisService) {
        this.securityProperties = securityProperties;
        this.redisService = redisService;
    }

    public ValidCode create(ValidCodeDTO validCodeDTO) {
        //创建
        ValidCode validCode = this.creatValidCode(validCodeDTO);
        //保存
        saveValidCode(validCode);
        return validCode;
    }

    /**
     * 创建验证码
     *
     * @param validCodeDTO /
     * @return /
     */
    protected abstract ValidCode creatValidCode(ValidCodeDTO validCodeDTO);


    /**
     * 简单的验证码生成
     * @return /
     */
    public String generateSimpleCode(){
        StringBuilder code=new StringBuilder();
        //生成验证码
        for (int i = 0; i < 6; i++) {
            code.append(ThreadLocalRandom.current().nextInt(10));
        }
        return code.toString();
    }

    public boolean valid(ValidCodeDTO validCodeDTO) {
        Map<String, String> map = buildKey(validCodeDTO);
        Object key = redisService.get(map.get("key"));
        if (Objects.isNull(key)) {
            return false;
        }
        ValidCodeChannelType channelType = ValidCodeChannelType.findValue(validCodeDTO.getChannel());
        boolean valid = false;
        switch (Objects.requireNonNull(channelType)) {
            case PICTURE:
                if (key.equals(validCodeDTO.getCode())) {
                    valid = true;
                }
                break;
            case SMS:
            case EMAIL:
                valid = true;
                break;
            default:
                break;
        }

        return valid;
    }

    /**
     * 创建验证码key
     *
     * @param validCodeDTO /
     * @return /
     */
    public Map<String, String> buildKey(ValidCodeDTO validCodeDTO) {
        String action = validCodeDTO.getAction();
        String channel = validCodeDTO.getChannel();
        String target = validCodeDTO.getTarget();
        String code=validCodeDTO.getCode();
        Map<String, String> map = new HashMap<>();
        map.put("key", SecureUtil.md5(securityProperties.getCodeKey() + action + channel + target + code));
        return map;
    }

    public void saveValidCode(ValidCode validCode) {
        String value = validCode.getValue();
        redisService.set(validCode.getKey(), value == null ? "" : value, 5, TimeUnit.MINUTES);
    }

}
