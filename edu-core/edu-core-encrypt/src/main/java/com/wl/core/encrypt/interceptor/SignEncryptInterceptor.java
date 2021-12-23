package com.wl.core.encrypt.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wl.core.encrypt.annotation.SignEncrypt;
import com.wl.core.encrypt.handler.SignEncryptHandler;
import com.wl.core.encrypt.wrapper.CacheRequestWrapper;
import com.wl.core.encrypt.wrapper.EncryptRequestWrapperFactory;
import lombok.AllArgsConstructor;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 签名加密拦截器
 *
 * @author gaoyang
 */
@AllArgsConstructor
public class SignEncryptInterceptor implements MethodInterceptor {

	private final String signSecret;
	private final SignEncryptHandler signEncryptHandler;

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		Object proceed = methodInvocation.proceed();
		CacheRequestWrapper request = (CacheRequestWrapper) ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
//		CacheRequestWrapper request = (CacheRequestWrapper) ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		if (!"post".equalsIgnoreCase(request.getMethod()) ||
				!EncryptRequestWrapperFactory.contentIsJson(request.getContentType())) {
			return proceed;
		}
		SignEncrypt annotation = methodInvocation.getMethod().getAnnotation(SignEncrypt.class);
		long timeout = annotation.timeout();
		TimeUnit timeUnit = annotation.timeUnit();
		if (((CacheRequestWrapper) request).getBody().length < 1) {
			return proceed;
		}
		Map<Object, Object> jsonMap = new ObjectMapper().readValue(request.getBody(), Map.class);
		return signEncryptHandler.handle(proceed, timeout, timeUnit, signSecret, jsonMap);
	}
}
