package com.wl.core.encrypt.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * 验证签名注解
 * 前端请求传输过来，请求里面有sign和timestamp字段，sign为请求参数签名后md5的值
 * 只拦截post请求,使用AOP
 *
 * @author gaoyang
 * @author pangu
 * @link https://github.com/gaoyang5323/Encrypt-Thanos
 * @date 2020-11-6
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SignEncrypt {

    long timeout() default 60000L;

    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;

}
