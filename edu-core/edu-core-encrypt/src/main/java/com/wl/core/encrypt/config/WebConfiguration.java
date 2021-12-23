package com.wl.core.encrypt.config;

import com.wl.core.encrypt.handler.EncryptHandler;
import com.wl.core.encrypt.props.EncryptProperties;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;


/**
 * web配置
 *
 * @author gaoyang 南顾北衫
 */
@Configuration
@AllArgsConstructor
@EnableConfigurationProperties(EncryptProperties.class)
public class WebConfiguration {

    @Autowired(required = false)
    private final EncryptHandler encryptHandler;

    @Autowired
    private  EncryptProperties encryptProperties;


    @Bean
    @Conditional(DefaultCondition.class)
    public FilterRegistrationBean filterRegistrationBean() {

        Integer order = encryptProperties.getOrder();
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new EncryptFilter(encryptHandler));
        bean.addUrlPatterns("/*");
        bean.setName("encryptFilter");
        bean.setOrder(order);
        return bean;
    }

    /**
     * debug模式下设置不加密
     */
    static class DefaultCondition implements Condition {
        @Override
        public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
            Environment environment = conditionContext.getEnvironment();
            Boolean debug = environment.getProperty("encrypt.debug",Boolean.class);
            return debug == null || !debug;
        }
    }
}
