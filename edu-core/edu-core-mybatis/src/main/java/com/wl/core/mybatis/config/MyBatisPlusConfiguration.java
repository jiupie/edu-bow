package com.wl.core.mybatis.config;

import com.wl.common.factory.YamlPropertySourceFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@Configuration
@MapperScan(basePackages = "com.wl.**.dao.**")
@PropertySource(factory = YamlPropertySourceFactory.class,value = "classpath:edu-db.yaml")
public class MyBatisPlusConfiguration {
}
