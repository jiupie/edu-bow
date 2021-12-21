package com.wl.core.oss.config;

import com.wl.common.constanst.ComponentConstant;
import com.wl.core.oss.core.OssTemplate;
import com.wl.core.oss.props.OssProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;


/**
 * AWS自动配置类
 * @author lengleng
 * @link https://github.com/pig-mesh/oss-spring-boot-starter
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(OssProperties.class)
public class OssConfiguration {

    @Autowired
    @SuppressWarnings("all")
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    @SuppressWarnings("all")
    private OssProperties properties;

    @Bean
    @ConditionalOnMissingBean(OssTemplate.class)
    @ConditionalOnProperty(name = "oss.enable", havingValue = "true", matchIfMissing = true)
    public OssTemplate ossTemplate() {
        return new OssTemplate(properties);
    }


    @Bean
    public OssProperties ossProperties(){
        return (OssProperties) redisTemplate.opsForValue().get(ComponentConstant.OSS_DEFAULT);
    }
}
