package com.wl.uaa.valid;

import cn.hutool.extra.template.TemplateUtil;
import com.wl.common.utils.SpringUtil;
import com.wl.core.mail.service.JavaMailTemplate;
import com.wl.core.redis.core.RedisService;
import com.wl.uaa.config.bean.SecurityProperties;
import com.wl.uaa.config.bean.ValidCode;
import com.wl.uaa.dto.ValidCodeDTO;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 邮件验证码
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class EmailValidCode extends AbstractValidCode {
    private final JavaMailTemplate javaMailTemplate;

    public EmailValidCode(SecurityProperties securityProperties, RedisService redisService) {
        super(securityProperties, redisService);
        this.javaMailTemplate = SpringUtil.getBean(JavaMailTemplate.class);
    }

    @Override
    public ValidCode creatValidCode(ValidCodeDTO validCodeDTO) {
        StringBuilder code=new StringBuilder();
        //生成验证码
        for (int i = 0; i < 6; i++) {
            code.append(ThreadLocalRandom.current().nextInt(10));
        }
        validCodeDTO.setCode(code.toString());
        Map<String, String> map = new HashMap<>();
        map.put("code",code.toString());
        try {
            //发送邮件
            javaMailTemplate.sendHtmlMail(validCodeDTO.getTarget(), "验证码",TemplateUtil.createEngine().getTemplate("/vaildCode.ftl").render(map));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        ValidCode validCode = new ValidCode();
        Map<String, String> data = buildKey(validCodeDTO);
        validCode.setKey(data.get("key"));
        return validCode;
    }
}
